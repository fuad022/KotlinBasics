package com.example.kotlinbasics

fun main() {
    val numbers = arrayOf(2, 4, 6, 8, 10)
    val average = calculateAverage(numbers)
    println("Average: $average")
}

fun calculateAverage(numbers: Array<Int>): Double {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum.toDouble() / numbers.size
}