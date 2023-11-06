package com.example.kotlinbasics

fun main() {
    val list = bubbleSortBS(intArrayOf(2, 15, 1, 8, 4))
    for (k in list) print("$k ")
}

fun bubbleSortBS(arr: IntArray): IntArray {
    var swap = true
    while (swap) {
        swap = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }

    return arr
}