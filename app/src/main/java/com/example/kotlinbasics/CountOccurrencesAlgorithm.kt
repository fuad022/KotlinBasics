package com.example.kotlinbasics

fun main() {
    val list = listOf(1, 2, 3, 4, 1, 2, 3, 1, 2, 1)
    val occurrences = countOccurrences(list)

    for ((element, count) in occurrences) {
        println("$element occurs $count times")
    }
}

fun <T> countOccurrences(list: List<T>): Map<T, Int> {
    val occurrences = mutableMapOf<T, Int>()

    for (element in list) {
        val currentCount = occurrences[element] ?: 0
        occurrences[element] = currentCount + 1
    }

    return occurrences
}