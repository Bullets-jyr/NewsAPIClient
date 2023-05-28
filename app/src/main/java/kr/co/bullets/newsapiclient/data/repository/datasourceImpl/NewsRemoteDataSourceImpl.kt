package kr.co.bullets.newsapiclient.data.repository.datasourceImpl

import kr.co.bullets.newsapiclient.data.api.NewsAPIService
import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsAPIService: NewsAPIService) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}