package com.poc.movies.services.movies

import com.poc.movies.domain.Movie
import com.poc.movies.domain.MoviesSearch
import com.poc.movies.services.movies.ports.MoviesRepository
import org.slf4j.LoggerFactory

class MoviesService(private val moviesRepository: MoviesRepository){
    private val logger = LoggerFactory.getLogger(javaClass)
    fun searchForMovies(search: MoviesSearch):List<Movie>{
        logger.info(search.toString())
        return this.moviesRepository.searchForMovies(search)
    }
}