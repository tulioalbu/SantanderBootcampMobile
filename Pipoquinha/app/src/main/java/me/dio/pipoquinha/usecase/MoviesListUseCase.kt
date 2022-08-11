package me.dio.pipoquinha.usecase

import me.dio.pipoquinha.data.MovieRepository

class MoviesListUseCase (private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}