package kr.co.bullets.newsapiclient.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.bullets.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import kr.co.bullets.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(app: Application, getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase)
    }
}