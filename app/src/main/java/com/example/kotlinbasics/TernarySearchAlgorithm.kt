package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    val target = 13
    val index = ternarySearch(arr, target)
    if (index != -1) {
        println("Element found at index: $index")
    } else {
        println("Element not found")
    }
}

fun ternarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid1 = left + (right - left) / 3
        val mid2 = right - (right - left) / 3

        if (arr[mid1] == target) return mid1
        if (arr[mid2] == target) return mid2

        if (target < arr[mid1]) {
            right = mid1 - 1
        } else if (target > arr[mid2]) {
            left = mid2 + 1
        } else {
            left = mid1 + 1
            right = mid2 - 1
        }
    }
    return -1 // If the target is not found in the array
}