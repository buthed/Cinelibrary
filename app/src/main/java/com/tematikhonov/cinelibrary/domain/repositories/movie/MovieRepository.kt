package com.tematikhonov.cinelibrary.domain.repositories.movie

import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import com.tematikhonov.cinelibrary.domain.models.ApiConstants
import com.tematikhonov.cinelibrary.BuildConfig.API_KEY
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getMovie(movie_id: Int) = apiService.getMovie(movie_id, API_KEY)

    suspend fun getCredits(movie_id: Int) = apiService.getCredits(movie_id, API_KEY)

    suspend fun getSimilarMovies(movie_id: Int) = apiService.getSimilarMovies(movie_id, API_KEY)

    suspend fun getGallery(movie_id: Int) = apiService.getGallery(movie_id, API_KEY)

    suspend fun getVideos(movie_id: Int) = apiService.getVideos(movie_id, API_KEY)
}