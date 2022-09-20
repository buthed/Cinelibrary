package com.tematikhonov.cinelibrary.domain.repositories.home

import com.tematikhonov.cinelibrary.BuildConfig.API_KEY
import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getGenres() = apiService.getGenres(API_KEY)

    suspend fun getPopularMovies() = apiService.getPopularMovies(API_KEY)

    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies(API_KEY)

}