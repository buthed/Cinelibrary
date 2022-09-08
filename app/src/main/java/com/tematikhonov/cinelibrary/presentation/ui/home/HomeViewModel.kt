package com.tematikhonov.cinelibrary.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.GenresResult
import com.tematikhonov.cinelibrary.domain.models.entites.MoviesListResult
import com.tematikhonov.cinelibrary.domain.repositories.home.HomeRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository): ViewModel() {

    private val _genres = MutableLiveData<GenresResult>()
    val genres: LiveData<GenresResult>
        get() = _genres

    private val _upcomingMovies = MutableLiveData<MoviesListResult>()
    val upcomingMovies: LiveData<MoviesListResult>
        get() = _upcomingMovies

    private val _popularMovies = MutableLiveData<MoviesListResult>()
    val popularMovies: LiveData<MoviesListResult>
        get() = _popularMovies

    init {
        getGenres()
        getUpcomingMovies()
        getPopularMovies()
    }

    private suspend fun fetchGenres() = flow {
        emit(repository.getGenres())
    }

    private suspend fun fetchUpcomingMovies() = flow {
        emit(repository.getUpcomingMovies())
    }

    private suspend fun fetchPopularMovies() = flow {
        emit(repository.getPopularMovies())
    }


    private fun getGenres() {
        viewModelScope.launch {
            fetchGenres().collect{
                _genres.postValue(it)
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            fetchUpcomingMovies().collect{
                _upcomingMovies.postValue(it)
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            fetchPopularMovies().collect{
                _popularMovies.postValue(it)
            }
        }
    }
}
