package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(1, 5, 9, 12, 7, 3, 15, 8)
    val target = 7
    val index = sequentialSearch(array, target)
    if (index != -1) {
        println("Element $target found at index $index")
    } else {
        println("Element $target not found in the array")
    }
}

fun sequentialSearch(array: IntArray, target: Int): Int {
    for (i in array.indices) {
        if (array[i] == target) {
            return i // Return the index where the target is found
        }
    }
    return -1
}