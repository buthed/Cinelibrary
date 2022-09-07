package com.tematikhonov.cinelibrary.domain.repositories.search

import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getMovieSearchResult(query: String) = apiService.getMovieSearchResult(query)
}