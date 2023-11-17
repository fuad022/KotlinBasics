package com.example.kotlinbasics

fun main() {
    val nums = intArrayOf(2, 3, 4, 7, 11)
    val k = 5

    val missingNumbers = findKMissingPositive(nums, k)

    println("The first $k missing positive numbers are: $missingNumbers")
}

fun findKMissingPositive(nums: IntArray, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    var missingCount = k
    var current = 1
    var index = 0

    while (missingCount > 0) {
        if (index < nums.size && nums[index] == current) {
            index++
        } else {
            result.add(current)
            missingCount--
        }
        current++
    }

    return result
}