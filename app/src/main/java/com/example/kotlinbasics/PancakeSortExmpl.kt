package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(3, 1, 2)
    val result = pancakeSort(arr)
    println("Sorted Array: ${arr.contentToString()}")
    println("Flips to Sort: $result")
}

fun pancakeSort(arr: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    var end = arr.size - 1

    while (end > 0) {
        var maxIndex = 0
        var maxVal = arr[0]
        for (i in 1..end) {
            if (arr[i] > maxVal) {
                maxVal = arr[i]
                maxIndex = i
            }
        }

        if (maxIndex != end) {
            if (maxIndex != 0) {
                flip(arr, maxIndex)
                result.add(maxIndex + 1)
            }

            flip(arr, end)
            result.add(end + 1)
        }

        end--
    }

    return result
}

fun flip(arr: IntArray, k: Int) {
    var start = 0
    var end = k
    while (start < end) {
        val temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        start++
        end--
    }
}