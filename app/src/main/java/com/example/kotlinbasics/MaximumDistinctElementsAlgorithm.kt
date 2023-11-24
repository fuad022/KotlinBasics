package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 1, 2, 3)
    val result = findMaxDistinctElements(array)
    println("Maximum distinct elements: $result")
}

fun findMaxDistinctElements(arr: IntArray): Int {
    if (arr.isEmpty()) {
        return 0
    }

    // Step 1: Sort the array
    arr.sort()

    // Step 2: Count the distinct elements
    var distinctCount = 1 // The first element is always distinct

    for (i in 1 until arr.size) {
        if (arr[i] != arr[i - 1]) {
            distinctCount++
        }
    }

    return distinctCount
}