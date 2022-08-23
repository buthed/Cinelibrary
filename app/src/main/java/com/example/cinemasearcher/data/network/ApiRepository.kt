package com.example.cinemasearcher.data.network

import com.example.cinemasearcher.data.models.TMDB_API_KEY
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPopularMovies() = apiService.getPopularMovies()

    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()
}