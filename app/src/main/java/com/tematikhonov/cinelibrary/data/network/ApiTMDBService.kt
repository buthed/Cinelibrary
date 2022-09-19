package com.tematikhonov.cinelibrary.data.network

import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_CAST
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_GALLERY
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_GENRES
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_API_KEY
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

    @GET(TMDB_API_MOVIE+TMDB_API_KEY)
    suspend fun getMovie(@Path("movie_id") movie_id: Int): Response<MovieDetails>

    @GET(TMDB_API_GENRES+TMDB_API_KEY)
    suspend fun getGenres(): GenresResult

    @GET(TMDB_API_POPULAR+TMDB_API_KEY)
    suspend fun getPopularMovies(): ResultMovie

    @GET(TMDB_API_UPCOMING+TMDB_API_KEY)
    suspend fun getUpcomingMovies(): ResultMovie

    @GET(TMDB_API_CAST+TMDB_API_KEY)
    suspend fun getCredits(@Path("movie_id") movie_id: Int): Credits

    @GET(TMDB_API_SIMILAR_MOVIES+TMDB_API_KEY)
    suspend fun getSimilarMovies(@Path("movie_id") movie_id: Int): ResultMovie

    @GET(TMDB_API_GALLERY+TMDB_API_KEY)
    suspend fun getGallery(@Path("movie_id") movie_id: Int): Gallery

    @GET(TMDB_API_VIDEOS+TMDB_API_KEY)
    suspend fun getVideos(@Path("movie_id") movie_id: Int): VideosResult

    @GET(TMDB_API_SEARCH_MOVIE+TMDB_API_KEY)
    suspend fun getMovieSearchResult(@Query("query") query: String): ResultMovie

    @GET(TMDB_API_SEARCH_PERSON+TMDB_API_KEY)
    suspend fun getPersonSearchResult(@Query("query") query: String): ResultPerson

    @GET(TMDB_API_PERSON+TMDB_API_KEY)
    suspend fun getPerson(@Path("person_id") person_id: Int): Person

    @GET(TMDB_API_LANGUAGES+TMDB_API_KEY)
    suspend fun getLanguages(): LanguagesList
}