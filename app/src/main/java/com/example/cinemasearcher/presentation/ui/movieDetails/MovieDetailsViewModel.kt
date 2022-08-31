package com.example.cinemasearcher.presentation.ui.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemasearcher.domain.models.entites.Movie
import com.example.cinemasearcher.domain.repositories.home.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    var movieId by Delegates.notNull<Int>()

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    private suspend fun fetchMovie(movieId: Int) = flow {
        emit(repository.getMovie(movieId))
    }

    private fun getMovie(movieId: Int) {
        viewModelScope.launch {
            fetchMovie(movieId).collect{
                _movie.postValue(it.body())
            }
        }
    }

    fun init(movieId: Int){
        this.movieId = movieId
        getMovie(movieId)
    }
}