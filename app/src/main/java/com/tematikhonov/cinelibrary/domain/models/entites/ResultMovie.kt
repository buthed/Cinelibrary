package com.tematikhonov.cinelibrary.domain.models.entites

data class ResultMovie(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)