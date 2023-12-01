package com.poc.movies.presentation

import io.ktor.server.routing.*


fun Routing.v1() {
    route("/api/v1/movies") {
        movies()
    }
}


