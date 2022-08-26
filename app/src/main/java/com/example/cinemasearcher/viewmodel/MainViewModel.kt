package com.example.cinemasearcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemasearcher.data.model.entites.Movie
import com.example.cinemasearcher.data.model.entites.PopularMoviesResult
import com.example.cinemasearcher.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    private val _popularMovies = MutableLiveData<PopularMoviesResult>()
    val popularMovies: LiveData<PopularMoviesResult>
        get() = _popularMovies


    init {
        getMovie()
        getPopularMovies()
    }

    private suspend fun fetchMovie() = flow {
        emit(repository.getMovie())
    }

    private suspend fun fetchPopularMovies() = flow {
        emit(repository.getPopularMovies())
    }


    private fun getMovie() {
        viewModelScope.launch {
            fetchMovie().collect{
                _movie.postValue(it.body())
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






//

//}




//
//


}