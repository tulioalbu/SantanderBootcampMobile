package me.dio.pipoquinha.repository

import android.util.Log
import me.dio.pipoquinha.api.MovieRestApiTask
import me.dio.pipoquinha.model.Movie
import me.dio.pipoquinha.viewmodel.MovieListViewModel.Companion.TAG

class MovieRepository (private val movieRestApiTask: MovieRestApiTask){

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }

        return movieList
    }
}