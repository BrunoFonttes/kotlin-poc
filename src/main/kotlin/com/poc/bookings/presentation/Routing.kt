package com.poc.bookings.presentation

import io.ktor.server.routing.*

fun Routing.v1() {
    route("/api/v1") {
        bookings()
    }
}
