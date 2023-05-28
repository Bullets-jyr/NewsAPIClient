package kr.co.bullets.newsapiclient.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.model.Article
import kr.co.bullets.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import kr.co.bullets.newsapiclient.data.util.Resource
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource) : NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }

        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}