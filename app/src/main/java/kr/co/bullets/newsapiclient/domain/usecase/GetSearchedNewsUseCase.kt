package kr.co.bullets.newsapiclient.domain.usecase

import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.util.Resource
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}