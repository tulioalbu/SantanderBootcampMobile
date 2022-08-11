package me.dio.pipoquinha.data

import me.dio.pipoquinha.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>

}