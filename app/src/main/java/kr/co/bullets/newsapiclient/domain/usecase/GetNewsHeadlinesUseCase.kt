package kr.co.bullets.newsapiclient.domain.usecase

import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.util.Resource
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}