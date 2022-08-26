package com.example.cinemasearcher.data.network

import com.example.cinemasearcher.data.model.ApiConstants.TMDB_API_GENRES
import com.example.cinemasearcher.data.model.ApiConstants.TMDB_API_KEY
import com.example.cinemasearcher.data.model.ApiConstants.TMDB_API_POPULAR
import com.example.cinemasearcher.data.model.ApiConstants.TMDB_API_UPCOMING
import com.example.cinemasearcher.data.model.entites.GenresResult
import com.example.cinemasearcher.data.model.entites.Movie
import com.example.cinemasearcher.data.model.entites.PopularMoviesResult
import com.example.cinemasearcher.data.model.entites.UpcomingMoviesResult
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/550?api_key=1cdc07942d44ead0f1079d449b6760a3")
    suspend fun getMovie(): Response<Movie>

    @GET(TMDB_API_GENRES+TMDB_API_KEY)
    suspend fun getGenres(): GenresResult

    @GET(TMDB_API_POPULAR+TMDB_API_KEY)
    suspend fun getPopularMovies(): PopularMoviesResult

    @GET(TMDB_API_UPCOMING+ TMDB_API_KEY)
    suspend fun getUpcomingMovies(): UpcomingMoviesResult
}