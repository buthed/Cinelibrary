package com.tematikhonov.cinelibrary.domain.models

object ApiConstants {
    const val TMDB_API_CINEMA_URL = "https://api.themoviedb.org"
    const val TMDB_API_MOVIE = "/3/movie/{movie_id}"
    const val TMDB_API_GENRES = "/3/genre/movie/list"
    const val TMDB_API_POPULAR = "/3/movie/now_playing"
    const val TMDB_API_UPCOMING = "/3/movie/upcoming"
    const val TMDB_API_CAST = "/3/movie/{movie_id}/credits"
    const val TMDB_API_SIMILAR_MOVIES = "/3/movie/{movie_id}/similar"
    const val TMDB_API_GALLERY ="/3/movie/{movie_id}/images"
    const val TMDB_API_VIDEOS = "/3/movie/{movie_id}/videos"
    const val TMDB_API_PERSON = "/3/person/{person_id}"
    const val TMDB_API_LANGUAGES = "/3/configuration/languages"
    const val TMDB_API_SEARCH_MOVIE = "/3/search/movie"
    const val TMDB_API_SEARCH_PERSON = "/3/search/person"
    const val TMDB_IMAGE_PATH = "https://image.tmdb.org/t/p/w500/"
    const val TMDB_API_NOW_PLAYING = "movie/now_playing"
}



