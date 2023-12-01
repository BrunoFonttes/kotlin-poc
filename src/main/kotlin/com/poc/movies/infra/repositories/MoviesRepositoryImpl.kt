package com.poc.movies.infra.repositories

import com.poc.movies.domain.Movie
import com.poc.movies.domain.MoviesSearch
import com.poc.movies.services.movies.ports.MoviesRepository
import java.time.ZonedDateTime

class MovieModel(
    val id: Int, val title: String, val durationInMinutes: Int, val showTime: ZonedDateTime, val availableSeats: Int
)

class MoviesRepositoryImpl : MoviesRepository {
    private val movies: Array<MovieModel> = arrayOf(
        MovieModel(1, "The Nun", 120, ZonedDateTime.now(), 10),
        MovieModel(2, "Barbie", 100, ZonedDateTime.now(), 0),
        MovieModel(3, "John Wick", 125, ZonedDateTime.now(), 1),
        MovieModel(4, "Oppenheimer", 130, ZonedDateTime.now(), 3),
        MovieModel(5, "Spider-man: No way home", 89, ZonedDateTime.now(), 5),
        MovieModel(6, "Peaky Blinders", 151, ZonedDateTime.now(), 50)
    )

    override fun searchForMovies(search: MoviesSearch): List<Movie> {
        val filteredMovies = this.movies.filter {
            val assertTitle = it.title == search.title
            val assertSeatsAmount = when(search.seatsAmount == null) {
                true -> true
                false ->  it.availableSeats >= search.seatsAmount
            }
            val assertShowDate = when(search.showDate== null){
                true -> true
                false -> it.showTime.isEqual(search.showDate)
            }

            assertTitle && assertSeatsAmount && assertShowDate
        }
        return filteredMovies.map { Movie.load(it.id, it.title, it.durationInMinutes, it.showTime, it.availableSeats) }
    }
}