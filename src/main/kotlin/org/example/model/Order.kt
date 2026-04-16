package org.example.model

data class Order(
    val id: String,
    val items: List<OrderItem>,
) {
    val total: Double get() = items.sumOf { it.product.price * it.quantity }
}

data class OrderItem(val product: Product, val quantity: Int)
