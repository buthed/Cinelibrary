package com.tematikhonov.cinelibrary.data.di

import android.content.Context
import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import com.tematikhonov.cinelibrary.domain.models.ApiConstants
import com.tematikhonov.cinelibrary.domain.repositories.profile.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : ApiTMDBService =
        Retrofit.Builder()
            .baseUrl(ApiConstants.TMDB_API_CINEMA_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiTMDBService::class.java)

    @Provides
    @Singleton
    fun provideRepository(@ApplicationContext context: Context): ProfileRepositoryImpl =
        ProfileRepositoryImpl(context)
}