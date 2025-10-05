package com.example.kotlinbasics

fun main() {
    val inputNumbers = listOf(1, 3, 5, 7, 9, 10)
    val missingNumbers = findMissingNumbers(inputNumbers)

    if (missingNumbers.isNotEmpty()) {
        println("Missing numbers: $missingNumbers")
    } else {
        println("No missing numbers found.")
    }
}

fun findMissingNumbers(numbers: List<Int>): List<Int> {
    val sortedNumbers = numbers.sorted()
    val missingNumbers = mutableListOf<Int>()

    for (i in 1 until sortedNumbers.lastOrNull()!!) {
        if (!sortedNumbers.contains(i)) {
            missingNumbers.add(i)
        }
    }

    return missingNumbers
}