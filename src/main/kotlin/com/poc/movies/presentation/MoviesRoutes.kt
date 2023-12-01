package com.poc.movies.presentation

import com.poc.movies.domain.MoviesSearch
import com.poc.movies.services.movies.MoviesService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun Route.movies(){
        val service by inject<MoviesService>()
        get("/") {
            val validationErrors = mutableListOf<String>()

            val title = call.request.queryParameters["title"]

            val showDate = try{
                val strShowDate = call.request.queryParameters["showDate"]
                if(!strShowDate.isNullOrEmpty()) {
                    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
                    ZonedDateTime.parse(strShowDate,formatter)
                }
                else{
                    null
                }
            }catch (e:Exception){
                validationErrors.add("showDate must be a date")
                null
            }

            val seatsAmount = try {
                call.request.queryParameters["seatsAmount"]?.toInt()
            } catch (e: Exception) {
                validationErrors.add("seatsAmount must be an integer")
                null
            }

            if(validationErrors.isNotEmpty()){
                throw PresentationException("invalid parameters",validationErrors)
            }

            val result = service.searchForMovies(MoviesSearch(title, showDate, seatsAmount))
            val response = result.map{MoviesDTO(it.title, it.showTime.toString(), it.availableSeats)}
            call.respond(HttpStatusCode.OK, response)
        }
}