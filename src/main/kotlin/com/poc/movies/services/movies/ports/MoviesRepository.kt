package com.poc.movies.services.movies.ports

import com.poc.movies.domain.Movie
import com.poc.movies.domain.MoviesSearch

interface MoviesRepository {
    fun searchForMovies(search: MoviesSearch):List<Movie>
}