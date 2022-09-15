package com.tematikhonov.cinelibrary.presentation.ui.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.*
import com.tematikhonov.cinelibrary.domain.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    var movieId by Delegates.notNull<Int>()

    private val _movie = MutableLiveData<MovieDetails>()
    val movie: LiveData<MovieDetails>
        get() = _movie

    private val _credits = MutableLiveData<Credits>()
    val credits: LiveData<Credits>
        get() = _credits

    private val _similar = MutableLiveData<ResultMovie>()
    val similar: LiveData<ResultMovie>
        get() = _similar

    private val _gallery = MutableLiveData<Gallery>()
    val gallery: LiveData<Gallery>
        get() = _gallery

    private val _videos = MutableLiveData<VideosResult>()
    val videos: LiveData<VideosResult>
        get() = _videos

    private suspend fun fetchMovie(movieId: Int) = flow {
        emit(repository.getMovie(movieId))
    }

    private suspend fun fetchCredits(movieId: Int) = flow {
        emit(repository.getCredits(movieId))
    }

    private suspend fun fetchSimilar(movieId: Int) = flow {
        emit(repository.getSimilarMovies(movieId))
    }

    private suspend fun fetchGallery(movieId: Int) = flow {
        emit(repository.getGallery(movieId))
    }

    private suspend fun fetchVideos(movieId: Int) = flow {
        emit(repository.getVideos(movieId))
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

    private fun getSimilar(movieId: Int) {
        viewModelScope.launch {
            fetchSimilar(movieId).collect{
                _similar.postValue(it)
            }
        }
    }

    private fun getGallery(movieId: Int) {
        viewModelScope.launch {
            fetchGallery(movieId).collect{
                _gallery.postValue(it)
            }
        }
    }

    private fun getVideos(movieId: Int) {
        viewModelScope.launch {
            fetchVideos(movieId).collect{
                _videos.postValue(it)
            }
        }
    }

    fun init(movieId: Int){
        this.movieId = movieId
        getMovie(movieId)
        getCredits(movieId)
        getSimilar(movieId)
        getGallery(movieId)
        getVideos(movieId)
    }
}