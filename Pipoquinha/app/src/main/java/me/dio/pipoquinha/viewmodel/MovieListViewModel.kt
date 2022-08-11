package me.dio.pipoquinha.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.dio.pipoquinha.api.MovieRestApiTask
import me.dio.pipoquinha.model.Movie
import me.dio.pipoquinha.repository.MovieRepository

class MovieListViewModel : ViewModel() {

    companion object
    {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init () {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }
        _moviesList.postValue(movieRepository.getAllMovies())
    }
}