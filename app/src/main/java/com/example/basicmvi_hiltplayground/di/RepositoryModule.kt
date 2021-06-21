package com.example.basicmvi_hiltplayground.di

import com.example.basicmvi_hiltplayground.repository.MainRepository
import com.example.basicmvi_hiltplayground.retrofit.BlogRetrofit
import com.example.basicmvi_hiltplayground.retrofit.NetworkMapper
import com.example.basicmvi_hiltplayground.room.BlogDao
import com.example.basicmvi_hiltplayground.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository{
        return MainRepository(blogDao,retrofit, cacheMapper, networkMapper)
    }
}