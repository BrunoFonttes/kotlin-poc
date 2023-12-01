package com.poc.plugins

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import com.poc.movies.di.appModule as movies

fun Application.configureKoin(){
    install(Koin) {
        slf4jLogger()
        modules(movies)
    }
}