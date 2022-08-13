package me.dio.pipoquinha.framework.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {

    companion object {
        const val BASE_URL ="https://tulioalbu.github.io/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)

}