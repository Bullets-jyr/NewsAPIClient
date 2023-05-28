package kr.co.bullets.newsapiclient.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.bullets.newsapiclient.data.api.NewsAPIService
import kr.co.bullets.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import kr.co.bullets.newsapiclient.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}