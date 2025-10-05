package com.example.kotlinbasics

fun main() {
    val sortedArray = intArrayOf(-3, -2, 0, 1, 4, 5)
    val squaredArray = squareSortedArray(sortedArray)

    for (num in squaredArray) {
        print("$num ")
    }
}

fun squareSortedArray(arr: IntArray): IntArray {
    val result = IntArray(arr.size)

    for (i in 0 until arr.size) {
        result[i] = arr[i] * arr[i]
    }

    return result
}