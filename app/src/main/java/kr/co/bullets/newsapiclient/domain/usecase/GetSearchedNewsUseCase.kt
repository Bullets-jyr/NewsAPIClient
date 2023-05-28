package kr.co.bullets.newsapiclient.domain.usecase

import kr.co.bullets.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}