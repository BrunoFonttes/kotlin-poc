package com.poc.movies.di

import com.poc.movies.infra.repositories.MoviesRepositoryImpl
import com.poc.movies.services.movies.MoviesService
import com.poc.movies.services.movies.ports.MoviesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module{
    singleOf(::MoviesRepositoryImpl){ bind<MoviesRepository>()}
    singleOf(::MoviesService)
}