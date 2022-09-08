package com.tematikhonov.cinelibrary.domain.models.entites

data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)