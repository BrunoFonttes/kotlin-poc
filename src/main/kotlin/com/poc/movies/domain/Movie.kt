package com.poc.movies.domain

import java.time.ZonedDateTime

class Movie private constructor(
    val id: Int,
    val title: String,
    val duration: String,
    val showTime: ZonedDateTime,
    val availableSeats: Int
) {
    companion object Factory {
        fun load(
            id: Int,
            title: String,
            durationInMinutes: Int,
            showTime: ZonedDateTime,
            availableSeats: Int
        ):Movie {
            val hours = durationInMinutes/60
            val minutes = durationInMinutes % 60
            val duration = "${hours}h ${minutes}m"
            return Movie(id, title, duration, showTime, availableSeats)
        }
    }
}
