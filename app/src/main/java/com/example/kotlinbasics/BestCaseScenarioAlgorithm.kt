package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(10, 5, 8, 20, 15) // Example array
    val max = findMax(array)
    println("The maximum element in the array is: $max")
}

fun findMax(array: IntArray): Int {
    // Initialize max variable to hold the maximum value found so far
    var max = array[0]

    // Loop through the array starting from the second element
    for (i in 1 until array.size) {
        // Check if the current element is greater then the max
        if (array[i] > max) {
            // If yes, update the max variable
            max = array[i]
        }
    }
    return max
}