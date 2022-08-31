package com.example.cinemasearcher.data.network

import androidx.lifecycle.MutableLiveData
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_CAST
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_GENRES
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_KEY
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_MOVIE
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_POPULAR
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_UPCOMING
import com.example.cinemasearcher.domain.models.entites.*
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiTMDBService {

    @GET(TMDB_API_MOVIE+TMDB_API_KEY)
    suspend fun getMovie(@Path("movie_id") movie_id: Int): Response<Movie>

    @GET(TMDB_API_GENRES+TMDB_API_KEY)
    suspend fun getGenres(): GenresResult

    @GET(TMDB_API_POPULAR+TMDB_API_KEY)
    suspend fun getPopularMovies(): PopularMoviesResult

    @GET(TMDB_API_UPCOMING+TMDB_API_KEY)
    suspend fun getUpcomingMovies(): UpcomingMoviesResult

    @GET(TMDB_API_CAST+ TMDB_API_KEY)
    suspend fun getCredits(@Path("movie_id") movie_id: Int): Credits
}