package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(5, 2, 9, 3, 4, 6, 8, 1, 7)
    println("Original Array: ${arr.joinToString(", ")}")
    oddEvenSort(arr)
    println("Sorted Array: ${arr.joinToString(", ")}")
}

fun oddEvenSort(arr: IntArray) {
    val n = arr.size
    var sorted = false

    while (!sorted) {
        sorted = true

        for (i in 1 until n - 1 step 2) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1)
                sorted = false
            }
        }

        for (i in 0 until n - 1 step 2) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1)
                sorted = false
            }
        }
    }
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}