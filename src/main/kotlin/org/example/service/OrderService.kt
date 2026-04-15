package org.example.service

import org.example.model.Order
import org.example.model.OrderItem
import org.example.repository.OrderRepository

class OrderService(private val repository: OrderRepository) {

    fun placeOrder(id: String, items: List<OrderItem>): Order {
        val order = Order(id, items)
        repository.save(order)
        return order
    }

    fun getOrder(id: String): Order? = repository.findById(id)

    fun listOrders(): List<Order> = repository.findAll()
}
