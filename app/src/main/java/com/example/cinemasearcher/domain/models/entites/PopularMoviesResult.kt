package com.example.cinemasearcher.domain.models.entites

data class PopularMoviesResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)