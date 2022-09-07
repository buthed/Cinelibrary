package com.tematikhonov.cinelibrary.domain.models

object ApiConstants {
    const val TMDB_API_CINEMA_URL = "https://api.themoviedb.org"
    const val TMDB_API_MOVIE = "/3/movie/{movie_id}?api_key="
    const val TMDB_API_GENRES = "/3/genre/movie/list?api_key="
    const val TMDB_API_POPULAR = "/3/movie/now_playing?api_key="
    const val TMDB_API_UPCOMING = "/3/movie/upcoming?api_key="
    const val TMDB_API_CAST = "/3/movie/{movie_id}/credits?api_key="
    const val TMDB_API_SIMILAR_MOVIES = "/3/movie/{movie_id}/similar?api_key="
    const val TMDB_API_GALLERY ="/3/movie/{movie_id}/images?api_key="
    const val TMDB_API_VIDEOS = "/3/movie/{movie_id}/videos?api_key="
    const val TMDB_API_SEARCH = "/3/search/movie"
    const val TMDB_IMAGE_PATH = "https://image.tmdb.org/t/p/w500/"
    const val TMDB_API_NOW_PLAYING = "movie/now_playing?api_key="
    const val TMDB_API_KEY = "1cdc07942d44ead0f1079d449b6760a3"
}


