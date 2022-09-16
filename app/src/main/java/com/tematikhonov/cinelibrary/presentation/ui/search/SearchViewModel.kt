package com.tematikhonov.cinelibrary.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.ResultMovie
import com.tematikhonov.cinelibrary.domain.models.entites.ResultPerson
import com.tematikhonov.cinelibrary.domain.repositories.search.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository): ViewModel() {

    var searchQuery by Delegates.notNull<String>()

    private val _searchMovie = MutableLiveData<ResultMovie>()
    val searchMovie: LiveData<ResultMovie>
        get() = _searchMovie

    private val _searchPerson = MutableLiveData<ResultPerson>()
    val searchPerson: LiveData<ResultPerson>
        get() = _searchPerson

    private suspend fun fetchSearchMovie(query: String) = flow {
        emit(repository.getMovieSearchResult(query))
    }

    private suspend fun fetchSearchPerson(query: String) = flow {
        emit(repository.getPersonSearchResult(query))
    }

    private fun getMovieSearchResult(query: String) {
        viewModelScope.launch {
            fetchSearchMovie(query).collect{
                _searchMovie.postValue(it)
            }
        }
    }

    private fun getPersonSearchResult(query: String) {
        viewModelScope.launch {
            fetchSearchPerson(query).collect{
                _searchPerson.postValue(it)
            }
        }
    }

    fun initMovieSearch(query: String){
        this.searchQuery = query
        getMovieSearchResult(query)
    }

    fun initPersonSearch(query: String){
        this.searchQuery = query
        getPersonSearchResult(query)
    }

    fun initMovieAndPersonSearch(query: String){
        this.searchQuery = query
        getMovieSearchResult(query)
        getPersonSearchResult(query)
    }
}