package com.example.kotlinbasics

fun main() {
    val names = mutableListOf(8, 3, 2, 7, 4)
    println(names)
    val ordered = insertionsortIS(names)
    println(ordered)
}

fun insertionsortIS(items: MutableList<Int>): List<Int> {
    if (items.isEmpty() || items.size < 2) {
        return items
    }
    for (count in 1..items.count() - 1) {
        val item = items[count]
        val i = count
        while (i > 0 && item < items[i - 1]) {
            items[i] = items[i - 1]
        }
        items[i] = item
    }
    return items
}