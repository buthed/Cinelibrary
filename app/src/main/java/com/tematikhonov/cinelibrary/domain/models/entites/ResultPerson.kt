package com.tematikhonov.cinelibrary.domain.models.entites

data class ResultPerson(
    val page: Int,
    val results: List<Person>,
    val total_pages: Int,
    val total_results: Int
)