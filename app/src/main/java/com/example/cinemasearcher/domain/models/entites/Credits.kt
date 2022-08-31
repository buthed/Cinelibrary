package com.example.cinemasearcher.domain.models.entites

data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)