package com.example.cinemasearcher.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovie() = apiService.getMovie()

    suspend fun getPopularMovies() = apiService.getPopularMovies()

//    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()
}