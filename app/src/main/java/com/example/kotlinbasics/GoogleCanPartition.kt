package com.example.kotlinbasics

fun main() {
    val nums = intArrayOf(1, 5, 11, 5)

    if (canPartitionGoogle(nums)) {
        println("The array can be partitioned into equal subsets.")
    } else {
        println("The array cannot be partitioned into equal subsets.")
    }
}

fun canPartitionGoogle(nums: IntArray): Boolean {
    val totalSum = nums.sum()

    if (totalSum % 2 != 0) {
        return false
    }

    val targetSum = totalSum / 2
    val dp = BooleanArray(targetSum + 1)

    dp[0] = true

    for (num in nums) {
        for (i in targetSum downTo num) {
            dp[i] = dp[i] || dp[i - num]
        }
    }

    return dp[targetSum]
}