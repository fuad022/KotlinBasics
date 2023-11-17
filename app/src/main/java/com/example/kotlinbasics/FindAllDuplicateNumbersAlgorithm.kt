package com.example.kotlinbasics

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 2, 6, 7, 8, 5)
    val duplicateNumbers = findDuplicates(numbers)

    if (duplicateNumbers.isNotEmpty()) {
        println("Duplicate numbers: $duplicateNumbers")
    } else {
        println("No duplicate found.")
    }
}

fun findDuplicates(numbers: List<Int>): List<Int> {
    val seen = HashSet<Int>()
    val duplicates = HashSet<Int>()

    for (number in numbers) {
        if (!seen.add(number)) {
            // If the numbers is already in the set, it's a duplicate
            duplicates.add(number)
        }
    }

    return duplicates.toList()
}