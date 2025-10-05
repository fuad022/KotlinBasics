package com.example.kotlinbasics

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 6, 5)
    val result = findSingleNumbers(nums)
    println("Single Numbers are: ${result.first} and ${result.second}")
}

fun findSingleNumbers(nums: IntArray): Pair<Int, Int> {
    // XOR all numbers to find XOR of the two single numbers
    var xorResult = 0
    for (num in nums) {
        xorResult = xorResult xor num
    }

    // Find a set bit in XOR result
    val setBit = xorResult and -xorResult

    var singleNum1 = 0
    var singleNum2 = 0
    for (num in nums) {
        if ((num and setBit) == 0) {
            // XOR the numbers with the set bit not set
            singleNum1 = singleNum1 xor num
        } else {
            // XOR the numbers with the set bit set
            singleNum2 = singleNum2 xor num
        }
    }

    return Pair(singleNum1, singleNum2)
}