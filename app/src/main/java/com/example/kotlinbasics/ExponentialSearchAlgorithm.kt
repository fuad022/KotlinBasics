package com.example.kotlinbasics

import kotlin.math.min

fun main() {
    val arr = intArrayOf(2, 3, 4, 10, 40)
    val key = 10
    val result = exponentialSearch(arr, key)
    if (result != -1) {
        println("Element found at index $result")
    } else {
        println("Element not found in the array")
    }
}

fun exponentialSearch(arr: IntArray, key: Int): Int {
    val n = arr.size
    if (arr[0] == key) return 0 // Element found at index 0

    // Find range for binary search by repeated doubling
    var i = 1
    while (i < n && arr[i] <= key) {
        i *= 2
    }

    // Call binary search for the found range
    return binarySearchES(arr, key, i / 2, min(i, n - 1))
}

fun binarySearchES(arr: IntArray, key: Int, low: Int, high: Int): Int {
    var lowIndex = low
    var highIndex = high

    while (lowIndex <= highIndex) {
        val mid = lowIndex + (highIndex - lowIndex) / 2

        when {
            arr[mid] == key -> return mid
            arr[mid] < key -> lowIndex = mid + 1
            else -> highIndex = mid - 1
        }
    }
    return -1 // Element not found
}