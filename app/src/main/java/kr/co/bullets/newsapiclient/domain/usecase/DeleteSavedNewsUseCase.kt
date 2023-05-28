package kr.co.bullets.newsapiclient.domain.usecase

import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}