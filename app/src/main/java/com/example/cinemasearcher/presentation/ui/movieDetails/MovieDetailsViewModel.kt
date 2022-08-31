package com.example.cinemasearcher.presentation.ui.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemasearcher.domain.models.entites.Credits
import com.example.cinemasearcher.domain.models.entites.Movie
import com.example.cinemasearcher.domain.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    var movieId by Delegates.notNull<Int>()

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    private val _credits = MutableLiveData<Credits>()
    val credits: LiveData<Credits>
        get() = _credits

    private suspend fun fetchMovie(movieId: Int) = flow {
        emit(repository.getMovie(movieId))
    }

    private suspend fun fetchCredits(movieId: Int) = flow {
        emit(repository.getCredits(movieId))
    }


    private fun getMovie(movieId: Int) {
        viewModelScope.launch {
            fetchMovie(movieId).collect{
                _movie.postValue(it.body())
            }
        }
    }

    private fun getCredits(movieId: Int) {
        viewModelScope.launch {
            fetchCredits(movieId).collect{
                _credits.postValue(it)
            }
        }
    }

    fun init(movieId: Int){
        this.movieId = movieId
        getMovie(movieId)
        getCredits(movieId)
    }
}