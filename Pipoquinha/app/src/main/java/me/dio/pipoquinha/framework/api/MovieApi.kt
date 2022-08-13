package me.dio.pipoquinha.framework.api

import me.dio.pipoquinha.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("Pipoquinha_API/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}