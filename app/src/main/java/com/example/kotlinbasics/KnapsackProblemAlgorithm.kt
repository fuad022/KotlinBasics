package com.example.kotlinbasics

fun main() {
    val items = listOf(
        ItemKnapsack(2,5),
        ItemKnapsack(3,10),
        ItemKnapsack(5,15),
        ItemKnapsack(7,20)
    )

    val capacity = 10

    val maxValue = knapsack(items, capacity)
    println("Максимальная стоимость предметов, помещающихся в рюкзак вместимостью $capacity: $maxValue")
}

data class ItemKnapsack(val weight: Int, val value: Int)

fun knapsack(items: List<ItemKnapsack>, capacity: Int): Int {
    val n = items.size
    val dp = Array(n + 1) { Array(capacity + 1) { 0 } }

    for (i in 1..n) {
        val currentItem = items[i - 1]
        for (w in 1..capacity) {
            if (currentItem.weight <= w) {
                dp[i][w] =
                    maxOf(currentItem.value + dp[i - 1][w - currentItem.weight], dp[i - 1][w])
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    return dp[n][capacity]
}