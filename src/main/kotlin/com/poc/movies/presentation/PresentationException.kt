package com.poc.movies.presentation

import kotlinx.serialization.Serializable

@Serializable
class PresentationException(override val message: String, val causes:MutableList<String>): Exception(message)