package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 6, 11, 5)
    val minSubsetSumDifference = findMinSubsetSumDifference(arr)
    println("Minimum Subset Sum Difference: $minSubsetSumDifference")
}

fun findMinSubsetSumDifference(arr: IntArray): Int {
    val totalSum = arr.sum()

    val targetSum = totalSum / 2
    val dp = BooleanArray(targetSum + 1)

    dp[0] = true

    for (num in arr) {
        for (j in targetSum downTo num) {
            dp[j] = dp[j] || dp[j - num]
        }
    }

    var lastTrueIndex = targetSum
    while (!dp[lastTrueIndex]) {
        lastTrueIndex--
    }

    val minSubsetSumDifference = totalSum - 2 * lastTrueIndex
    return minSubsetSumDifference
}