package com.example.kotlinbasics

fun main() {
    val items = listOf(
        ItemFKP(10, 60),
        ItemFKP(20, 100),
        ItemFKP(30, 120)
    )
    val capacity = 50
    val maxValue = fractionalKnapsack(items, capacity)
    println("Maximum value obtainable: $maxValue")
}

data class ItemFKP(val weight: Int, val value: Int)

fun fractionalKnapsack(items: List<ItemFKP>, capacity: Int): Double {
    val sortedItem = items.sortedByDescending { it.value.toDouble() / it.weight }
    var remainingCapacity = capacity
    var totalValue = 0.0

    for (item in sortedItem) {
        if (remainingCapacity >= item.weight) {
            totalValue += item.value
            remainingCapacity -= item.weight
        } else {
            val fraction = remainingCapacity.toDouble() / item.weight
            totalValue += item.value * fraction
            break
        }
    }

    return totalValue
}