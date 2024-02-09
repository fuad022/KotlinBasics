package com.example.kotlinbasics
 
fun main() {
    val items = listOf(
        ItemKnapsackTest("Laptop", 4, 1500),
        ItemKnapsackTest("Headphones", 1, 300),
        ItemKnapsackTest("Watch", 2, 200),
        ItemKnapsackTest("Book", 3, 100),
        ItemKnapsackTest("Water Bottle", 2, 50)
    )

    val capacity = 7
    val selectedItems = knapsack(items, capacity)

    println("Selected items:")
    selectedItems.forEach { println("${it.name} (weight: ${it.weight}, value: ${it.value})") }
}

data class ItemKnapsackTest(val name: String, val weight: Int, val value: Int)

fun knapsack(items: List<ItemKnapsackTest>, capacity: Int): List<ItemKnapsackTest> {
    val sortedItems = items.sortedByDescending { it.value.toDouble() / it.weight }

    var remainingCapacity = capacity
    val selectedItems = mutableListOf<ItemKnapsackTest>()

    for (item in sortedItems) {
        if (remainingCapacity >= item.weight) {
            selectedItems.add(item)
            remainingCapacity -= item.weight
        }
    }

    return selectedItems
}