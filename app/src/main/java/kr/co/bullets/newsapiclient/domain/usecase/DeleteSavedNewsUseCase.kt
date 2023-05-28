package kr.co.bullets.newsapiclient.domain.usecase

import kr.co.bullets.newsapiclient.data.model.Article
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}