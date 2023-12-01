package com.poc.movies

import com.poc.movies.presentation.v1
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.endpoints() {
    routing {
        v1()
    }
}