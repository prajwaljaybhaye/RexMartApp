package com.codewithandro.api28days

data class Cart(
    val discountedTotal: Double,
    val id: Int,
    val products: List<ProductX>,
    val total: Double,
    val totalProducts: Int,
    val totalQuantity: Int,
    val userId: Int
)