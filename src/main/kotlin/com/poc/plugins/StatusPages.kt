package com.poc.plugins

import com.poc.movies.domain.DomainException
import com.poc.movies.presentation.PresentationException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import org.slf4j.LoggerFactory


fun Application.configureStatusPages() {
     val logger = LoggerFactory.getLogger("internalError")
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            logger.error("$cause")
            when (cause) {
                is PresentationException -> {
                    call.response.status(HttpStatusCode.BadRequest)
                    call.respond(cause)
                }

                is DomainException -> {
                    call.response.status(HttpStatusCode.UnprocessableEntity)
                    call.respond(cause)
                }
                else -> {
                    call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
                }
            }

        }
    }
}