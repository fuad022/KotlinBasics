package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(5, 4, 3, 2, 1) // Reverse sorted array
    bubbleSortWorstCase(arr)
    println("Sorted array:")
    for (element in arr) {
        print("$element ")
    }
}

fun bubbleSortWorstCase(arr: IntArray) {
    val n = arr.size
    var swapped: Boolean
    for (i in 0 until n - 1) {
        swapped = false
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        // If no two elements were swapped in the inner loop, then the array is already sorted
        if (!swapped)
            break
    }
}