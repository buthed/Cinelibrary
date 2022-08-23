package com.example.cinemasearcher.data.network

import com.example.cinemasearcher.data.models.Movie
import com.example.cinemasearcher.data.models.TMDB_API_KEY
import com.example.cinemasearcher.data.models.TMDB_API_POPULAR
import com.example.cinemasearcher.data.models.TMDB_API_UPCOMING
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(TMDB_API_POPULAR+TMDB_API_KEY)
    suspend fun getPopularMovies() : Response<List<Movie>>

    @GET(TMDB_API_UPCOMING+ TMDB_API_KEY)
    suspend fun getUpcomingMovies() : Response<List<Movie>>
}