package com.poc.movies.domain

import kotlinx.serialization.Serializable

@Serializable
class DomainException(override val message:String) : Exception(message){
    val error = this::class.simpleName
}