package com.example.cinemasearcher.data.model.entites

data class UpcomingMoviesResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)