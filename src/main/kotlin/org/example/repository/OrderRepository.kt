package org.example.repository

import org.example.model.Order

class OrderRepository {
    private val orders = mutableMapOf<String, Order>()

    fun save(order: Order) { orders[order.id] = order }
    fun findById(id: String): Order? = orders[id]
    fun findAll(): List<Order> = orders.values.toList()
}
