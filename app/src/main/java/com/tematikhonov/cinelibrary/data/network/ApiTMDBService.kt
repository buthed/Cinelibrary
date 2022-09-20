package com.tematikhonov.cinelibrary.data.network

import com.tematikhonov.cinelibrary.BuildConfig.API_KEY
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_CAST
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_GALLERY
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_GENRES
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_LANGUAGES
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_MOVIE
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_PERSON
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_POPULAR
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_SEARCH_MOVIE
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_SEARCH_PERSON
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_SIMILAR_MOVIES
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_UPCOMING
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_VIDEOS
import com.tematikhonov.cinelibrary.domain.models.entites.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiTMDBService {

    @GET(TMDB_API_MOVIE)
    suspend fun getMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<MovieDetails>

    @GET(TMDB_API_GENRES)
    suspend fun getGenres(
        @Query("api_key") apiKey: String = API_KEY
    ): GenresResult

    @GET(TMDB_API_POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
    ): ResultMovie

    @GET(TMDB_API_UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): ResultMovie

    @GET(TMDB_API_CAST)
    suspend fun getCredits(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): Credits

    @GET(TMDB_API_SIMILAR_MOVIES)
    suspend fun getSimilarMovies(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ResultMovie

    @GET(TMDB_API_GALLERY)
    suspend fun getGallery(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Gallery

    @GET(TMDB_API_VIDEOS)
    suspend fun getVideos(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): VideosResult

    @GET(TMDB_API_SEARCH_MOVIE)
    suspend fun getMovieSearchResult(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("query") query: String
    ): ResultMovie

    @GET(TMDB_API_SEARCH_PERSON)
    suspend fun getPersonSearchResult(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("query") query: String
    ): ResultPerson

    @GET(TMDB_API_PERSON)
    suspend fun getPerson(
        @Path("person_id") person_id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Person

    @GET(TMDB_API_LANGUAGES)
    suspend fun getLanguages(
        @Query("api_key") apiKey: String = API_KEY
    ): LanguagesList
}