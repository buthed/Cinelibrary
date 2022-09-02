package com.example.cinemasearcher.data.network

import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_CAST
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_GALLERY
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_GENRES
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_KEY
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_MOVIE
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_POPULAR
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_SEARCH
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_SIMILAR_MOVIES
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_API_UPCOMING
import com.example.cinemasearcher.domain.models.entites.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiTMDBService {

    @GET(TMDB_API_MOVIE+TMDB_API_KEY)
    suspend fun getMovie(@Path("movie_id") movie_id: Int): Response<Movie>

    @GET(TMDB_API_GENRES+TMDB_API_KEY)
    suspend fun getGenres(): GenresResult

    @GET(TMDB_API_POPULAR+TMDB_API_KEY)
    suspend fun getPopularMovies(): MoviesListResult

    @GET(TMDB_API_UPCOMING+TMDB_API_KEY)
    suspend fun getUpcomingMovies(): MoviesListResult

    @GET(TMDB_API_CAST+TMDB_API_KEY)
    suspend fun getCredits(@Path("movie_id") movie_id: Int): Credits

    @GET(TMDB_API_SIMILAR_MOVIES+TMDB_API_KEY)
    suspend fun getSimilarMovies(@Path("movie_id") movie_id: Int): MoviesListResult

    @GET(TMDB_API_GALLERY+TMDB_API_KEY)
    suspend fun getGallery(@Path("movie_id") movie_id: Int): Gallery

    @GET("/3/search/movie?api_key=1cdc07942d44ead0f1079d449b6760a3&")
    suspend fun getMovieSearchResult(@Query("query") query: String): MoviesListResult
}