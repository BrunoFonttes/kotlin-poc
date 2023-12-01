package com.poc.bookings.presentation

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.bookings() {
    get("/") {
        call.respondText("Hello from 'bookings'!")
    }
}
