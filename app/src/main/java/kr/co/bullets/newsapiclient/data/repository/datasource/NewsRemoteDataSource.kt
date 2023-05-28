package kr.co.bullets.newsapiclient.data.repository.datasource

import kr.co.bullets.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>
}