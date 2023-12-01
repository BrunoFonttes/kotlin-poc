package com.poc

import com.poc.plugins.configureKoin
import com.poc.plugins.configureSerialization
import com.poc.plugins.configureStatusPages
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.poc.bookings.endpoints as bookingsEndpoints
import com.poc.movies.endpoints as moviesEndpoints

fun main() {
    System.setProperty("io.ktor.development", "true")
    embeddedServer(
        Netty, port = 8080,
        host = "0.0.0.0",
        watchPaths = listOf("classes","resources"),
        module = Application::module
    )
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureStatusPages()
    configureKoin()
    bookingsEndpoints()
    moviesEndpoints()
}
