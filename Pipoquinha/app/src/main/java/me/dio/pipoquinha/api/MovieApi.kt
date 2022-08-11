package me.dio.pipoquinha.api

import me.dio.pipoquinha.model.Movie
import retrofit2.http.GET

interface MovieApi {

    // https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/main/moviesList

    @GET("natanfelipe/FilmesFlixJson/main/moviesList")
    fun getAllMovies(): List<Movie>

}