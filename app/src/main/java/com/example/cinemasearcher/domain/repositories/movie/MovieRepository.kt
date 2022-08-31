package com.example.cinemasearcher.domain.repositories.movie

import com.example.cinemasearcher.data.network.ApiTMDBService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getMovie(movie_id: Int) = apiService.getMovie(movie_id)

    suspend fun getCredits(movie_id: Int) = apiService.getCredits(movie_id)

    suspend fun getSimilarMovies(movie_id: Int) = apiService.getSimilarMovies(movie_id)

    suspend fun getGallery(movie_id: Int) = apiService.getGallery(movie_id)
}