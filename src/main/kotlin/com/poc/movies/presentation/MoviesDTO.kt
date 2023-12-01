package com.poc.movies.presentation

import kotlinx.serialization.Serializable

@Serializable
class MoviesDTO(val title:String?,val showTime: String?, val availableSeats: Int?)
