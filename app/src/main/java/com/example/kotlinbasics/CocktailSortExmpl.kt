package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    println("Original array: ${arr.joinToString(", ")}")

    cocktailSort(arr)

    println("Sorted array: ${arr.joinToString(", ")}")
}

fun cocktailSort(arr: IntArray) {
    var swapped: Boolean
    var start = 0
    var end = arr.size - 1

    do {
        swapped = false

        for (i in start until end) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }

        if (!swapped) {
            break
        }

        swapped = false

        end--

        for (i in end downTo start + 1) {
            if (arr[i] < arr[i - 1]) {
                val temp = arr[i]
                arr[i] = arr[i - 1]
                arr[i - 1] = temp
                swapped = true
            }
        }
        start++
    } while (swapped)
}