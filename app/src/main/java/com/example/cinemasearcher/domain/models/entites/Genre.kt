package com.example.cinemasearcher.domain.models.entites

data class Genre(
    val id: Int,
    val name: String,
    val selected: Boolean =false
)