package com.poc.bookings

import com.poc.bookings.presentation.v1
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.endpoints() {
    routing {
        v1()
    }
}