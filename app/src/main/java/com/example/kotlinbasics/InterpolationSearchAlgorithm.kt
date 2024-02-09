package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15)
    val x = 11
    val index = interpolationSearch(arr, x)
    if (index != -1) {
        println("Element found at index $index")
    } else {
        println("Element not found")
    }
}

fun interpolationSearch(arr: IntArray, x: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high && x in arr[low]..arr[high]) {
        if (low == high) {
            if (arr[low] == x) return low
            else return -1
        }

        val pos = low + (((x - arr[low]) * (high - low)) / (arr[high] - arr[low]))

        when {
            arr[pos] == x -> return pos
            arr[pos] < x -> low = pos + 1
            else -> high = pos - 1
        }
    }
    return -1
}