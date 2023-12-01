package com.poc.movies.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(val name: String, val price: Float, val discount: Float, val discountPrice: Float)
