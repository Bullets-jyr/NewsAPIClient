package kr.co.bullets.newsapiclient.domain.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.model.Article
import kr.co.bullets.newsapiclient.data.util.Resource

interface NewsRepository {

    suspend fun getNewsHeadlines(): Resource<APIResponse>

    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    // we could write the return types as a list of articles like this
    // but we want to get real time updates from the database
    // we want to get notified of every change that happens in the Article’s table.
    // so, we could use LiveData with the list like this
    // we should always try to use LiveData in ViewModels and Observe them from Activities and Fragments
    // but it is not recommended to use LiveData in repositories. That will cause, unexpected threading issues.
    // before Kotlin Coroutines, most of the developers used Rxjava to get data from the repositories to ViewModel and then
    // used LiveData to emit those data from the view models to Activities and Fragments.
    // but now we have coroutines Flow api.
    // Flow API in Kotlin is a better way to handle the stream of data asynchronously
    // we will collect this stream of data flow and emit it as a live data.
    // since this function returns a data stream, we don’t need to write this function as a suspending function
    // we don’t want to pause this function and resume it at a later time.
    fun getSavedNews(): Flow<List<Article>>
}