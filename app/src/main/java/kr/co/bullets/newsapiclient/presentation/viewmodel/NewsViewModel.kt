package kr.co.bullets.newsapiclient.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.util.Resource
import kr.co.bullets.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase

class NewsViewModel(private val app: Application, private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase) : AndroidViewModel(app) {
    val newsHeadlines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    // now our function will do its operations in a background worker thread
    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadlines.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadlines.postValue(apiResult)
            } else {
                newsHeadlines.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            newsHeadlines.postValue(Resource.Error(e.message.toString()))
        }
    }

    // here, we need to pass the application context as an argument
    // in order to do that, we have to extend AndroidViewModel instead of ViewModel
    private fun isNetworkAvailable(context: Context): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}