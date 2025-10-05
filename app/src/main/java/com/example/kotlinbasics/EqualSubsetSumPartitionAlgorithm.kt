package com.example.kotlinbasics

fun main() {
    val nums = intArrayOf(1, 5, 11, 5)

    if (canPartition(nums)) {
        println("The array can be partitioned into equal subsets.")
    } else {
        println("The array cannot be partitioned into equal subsets.")
    }
}

fun canPartition(nums: IntArray): Boolean {
    val totalSum = nums.sum()

    if (totalSum % 2 != 0) {
        return false
    }

    val targetSum = totalSum / 2
    val n = nums.size

    val dp = Array(n + 1) { BooleanArray(targetSum + 1) }

    for (i in 0..n) {
        dp[i][0] = true
    }

    for (i in 1..n) {
        for (j in 1..targetSum) {
            dp[i][j] = dp[i - 1][j]

            if (j >= nums[i - 1]) {
                dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]
            }
        }
    }

    return dp[n][targetSum]
}