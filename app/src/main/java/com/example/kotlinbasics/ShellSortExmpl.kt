package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(12, 34, 54, 2, 3)

    println("Original Array: ${arr.joinToString(", ")}")
    shellSortSS(arr)
    println("Sorted Array: ${arr.joinToString(", ")}")
}

fun shellSortSS(arr: IntArray) {
    val n = arr.size
    var gap = n / 2

    while (gap > 0) {
        for (i in gap until n) {
            val temp = arr[i]
            var j = i

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }

            arr[j] = temp
        }

        gap /= 2
    }
}