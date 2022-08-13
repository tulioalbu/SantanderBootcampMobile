package me.dio.pipoquinha.framework.api

import me.dio.pipoquinha.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("tulioalbu/Pipoquinha_API/main/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}