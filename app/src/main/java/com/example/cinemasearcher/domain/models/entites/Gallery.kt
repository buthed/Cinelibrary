package com.example.cinemasearcher.domain.models.entites

data class Gallery(
    val backdrops: List<Backdrop>,
    val id: Int,
    val logos: List<Logo>,
    val posters: List<Poster>
)