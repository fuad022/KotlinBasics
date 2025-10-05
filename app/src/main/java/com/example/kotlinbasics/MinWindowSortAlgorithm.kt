package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 3, 5, 2, 6, 4, 8)
    val result = minimumWindowSort(arr)
    println("The minimum window to be sorted is $result")
}

fun minimumWindowSort(arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1

    // Find the first element out of sorting order from the beginning
    while (left < arr.size - 1 && arr[left] <= arr[left + 1]) {
        left++
    }

    // If the array is already sorted
    if (left == arr.size - 1) {
        return 0
    }

    // Find the first element out of sorting order from the end
    while (right > 0 && arr[right] >= arr[right - 1]) {
        right--
    }

    // Find the minimum and maximum in the unsorted part
    var minUnsorted = Int.MAX_VALUE
    var maxUnsorted = Int.MIN_VALUE
    for (i in left..right) {
        minUnsorted = minOf(minUnsorted, arr[i])
        maxUnsorted = maxOf(maxUnsorted, arr[i])
    }

    // Extend the unsorted part to include any elements out of its range
    while (left > 0 && arr[left - 1] > minUnsorted) {
        left--
    }

    while (right < arr.size - 1 && arr[right + 1] < maxUnsorted) {
        right++
    }

    // Length of the subarray to be sorted
    return right - left + 1
}