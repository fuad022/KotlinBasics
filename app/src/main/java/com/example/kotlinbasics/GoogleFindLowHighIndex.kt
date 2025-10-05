package com.example.kotlinbasics

fun main() {
    val sortedArray = intArrayOf(1, 2, 2, 2, 4, 4, 5, 6)
    val target = 2

    val lowIndex = findLowIndex(sortedArray, target)
    val highIndex = findHighIndex(sortedArray, target)

    println("Low Index: $lowIndex")
    println("High Index: $highIndex")
}

fun findLowIndex(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var result = -1

    while (low <= high) {
        val mid = (low + high) / 2

        if (array[mid] >= target) {
            high = mid - 1
            result = mid
        } else {
            low = mid + 1
        }
    }

    return result
}

fun findHighIndex(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    var result = -1

    while (low <= high) {
        val mid = (low + high) / 2

        if (array[mid] <= target) {
            low = mid + 1
            result = mid
        } else {
            high = mid - 1
        }
    }

    return result
}