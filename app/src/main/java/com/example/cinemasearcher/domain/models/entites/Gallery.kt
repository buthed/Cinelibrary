package com.example.cinemasearcher.domain.models.entites

data class Gallery(
    val backdrops: List<Image>,
    val id: Int,
    val logos: List<Image>,
    val posters: List<Image>
)