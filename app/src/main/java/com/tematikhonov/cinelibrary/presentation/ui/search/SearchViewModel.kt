package com.tematikhonov.cinelibrary.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.MoviesListResult
import com.tematikhonov.cinelibrary.domain.repositories.search.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository): ViewModel() {

    var searchQuery by Delegates.notNull<String>()

    private val _search = MutableLiveData<MoviesListResult>()
    val search: LiveData<MoviesListResult>
        get() = _search

    private suspend fun fetchSearch(query: String) = flow {
        emit(repository.getMovieSearchResult(query))
    }

    private fun getMovieSearchResult(query: String) {
        viewModelScope.launch {
            fetchSearch(query).collect{
                _search.postValue(it)
            }
        }
    }

    fun init(query: String){
        this.searchQuery = query
        getMovieSearchResult(query)
    }
}