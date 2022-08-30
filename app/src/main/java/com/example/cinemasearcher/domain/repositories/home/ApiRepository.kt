package com.example.cinemasearcher.domain.repositories.home

import com.example.cinemasearcher.data.network.ApiTMDBService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getMovie() = apiService.getMovie()

    suspend fun getGenres() = apiService.getGenres()

    suspend fun getPopularMovies() = apiService.getPopularMovies()

    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies()
}