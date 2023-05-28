package kr.co.bullets.newsapiclient.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.co.bullets.newsapiclient.data.model.APIResponse
import kr.co.bullets.newsapiclient.data.model.Article
import kr.co.bullets.newsapiclient.data.util.Resource
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}