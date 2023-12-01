package com.poc.movies.domain

import java.time.ZonedDateTime

val pattern = "[A-z0-9 ]".toRegex()

data class MoviesSearch(val title:String?, val showDate: ZonedDateTime?, val seatsAmount: Int? ){
    init{
        try {
            if (title != null) {
                require(pattern.find(title) != null) {
                    "The title $title does not match the pattern $pattern"
                }
            }
            if (showDate != null) {
                val today = ZonedDateTime.now()
                print("$today\n")
                require(showDate.isEqual(today) || showDate.isAfter(today)) {
                    "The showDate $showDate must be equal or after today"
                }
            }
            if (seatsAmount != null) {
                require(seatsAmount > 0) {
                    "The seatsAmount $seatsAmount must be greater than 0"
                }
            }
        }catch (e:Exception){
            if(e is IllegalArgumentException){
                throw DomainException(e.localizedMessage)
            }
            throw e
        }
    }
}