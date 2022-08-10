package me.dio.pipoquinha.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.dio.pipoquinha.model.Movie

class MovieListViewModel : ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            title = "Titanic",
            description = null,
            image = null,
            releasedate = null
        ),
        Movie(
            id = 1,
            title = "Central do Brasil",
            description = null,
            image = null,
            releasedate = null
        ),
    )

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init () {
        getAllMovies()
    }

    private fun getAllMovies() {
        _moviesList.value = listOfMovies
    }
}