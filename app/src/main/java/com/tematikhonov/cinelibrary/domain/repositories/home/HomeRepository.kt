package com.tematikhonov.cinelibrary.domain.repositories.home

import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getGenres() = apiService.getGenres()

    suspend fun getPopularMovies() = apiService.getPopularMovies()

    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()

}