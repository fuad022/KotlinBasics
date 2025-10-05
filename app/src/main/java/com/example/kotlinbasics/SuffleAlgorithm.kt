package com.example.kotlinbasics

fun main() {
    val numbers = arrayOf(1, 2, 3, 4, 5)
    println("Original array: ${numbers.joinToString()}")
    numbers.shuffle()
    println("Shuffle array: ${numbers.joinToString()}")
}

fun <T> Array<T>.shuffleAlgorithm(): Array<T> {
    val random = java.util.Random()
    for (i in size - 1 downTo 1) {
        val j = random.nextInt(i + 1)
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
    return this
}