package org.example

import org.example.model.OrderItem
import org.example.model.Product
import org.example.repository.OrderRepository
import org.example.service.OrderService

fun main() {
    val service = OrderService(OrderRepository())

    val apple = Product("p1", "Apple", 1.5)
    val book = Product("p2", "Book", 35.0)

    val order = service.placeOrder("order-001", listOf(
        OrderItem(apple, 3),
        OrderItem(book, 1),
    ))

    println("Order: ${order.id}, total: ${order.total}")
    println("All orders: ${service.listOrders().size}")
}
