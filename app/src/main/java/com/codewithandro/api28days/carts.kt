package com.codewithandro.api28days

data class carts(
    val carts: List<Cart>,
    val limit: Int,
    val skip: Int,
    val total: Int
)