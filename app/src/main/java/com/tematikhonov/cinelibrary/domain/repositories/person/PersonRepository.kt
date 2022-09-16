package com.tematikhonov.cinelibrary.domain.repositories.person

import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import javax.inject.Inject

class PersonRepository @Inject constructor(private val apiService: ApiTMDBService) {

    suspend fun getPerson(person_id: Int) = apiService.getPerson(person_id)
}