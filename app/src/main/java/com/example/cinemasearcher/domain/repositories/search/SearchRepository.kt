package com.example.cinemasearcher.domain.repositories.search

import com.example.cinemasearcher.data.network.ApiTMDBService
import retrofit2.http.Query
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getMovieSearchResult(query: String) = apiService.getMovieSearchResult(query)
}