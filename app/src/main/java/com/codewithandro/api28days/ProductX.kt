package com.codewithandro.api28days

data class ProductX(
    val discountPercentage: Double,
    val discountedTotal: Double,
    val id: Int,
    val price: Double,
    val quantity: Int,
    val thumbnail: String,
    val title: String,
    val total: Double
)