package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(1, 3, 6, 8, 10, 12)
    val target = 7
    val k = 3

    val closestNumbers = findClosestNumbers(array, target, k)
    println("Closest $k numbers to $target are: $closestNumbers")
}

fun findClosestNumbers(array: IntArray, target: Int, k: Int): List<Int> {
    val result = mutableListOf<Int>()

    // Binary search to find the closest element to the target
    var closestIndex = binarySearchCN(array, target)

    // Initialize two pointers to move towards the beginning and end of the array
    var left = closestIndex - 1
    var right = closestIndex

    // Merge the closest elements into the result list
    repeat(k) {
        if (left >= 0 && right < array.size) {
            val leftDiff = Math.abs(array[left] - target)
            val rightDiff = Math.abs(array[right] - target)

            if (leftDiff <= rightDiff) {
                result.add(array[left])
                left--
            } else {
                result.add(array[right])
                right++
            }
        } else if (left >= 0) {
            result.add(array[left])
            left--
        } else if (right < array.size) {
            result.add(array[right])
            right++
        }
    }

    return result
}

fun binarySearchCN(array: IntArray, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (array[mid] == target) {
            return mid
        } else if (array[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    // If the target is not in the array, return the index of the closest element
    return if (right < 0) 0 else if (left >= array.size) array.size - 1 else {
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) left else right
    }
}