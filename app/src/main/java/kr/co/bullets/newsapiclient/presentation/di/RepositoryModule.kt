package kr.co.bullets.newsapiclient.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.bullets.newsapiclient.data.repository.NewsRepositoryImpl
import kr.co.bullets.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import kr.co.bullets.newsapiclient.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}