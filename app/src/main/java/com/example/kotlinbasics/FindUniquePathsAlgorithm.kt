package com.example.kotlinbasics

fun main() {
    val m = 3
    val n = 7
    val result = uniquePaths(m, n)
    println("Number of unique pathsin a $m x $n grid: $result")
}

fun uniquePaths(m: Int, n: Int): Int {
    // Create a 2D array to store the number of unique paths at each position
    val dp = Array(m) { IntArray(n) }

    for (i in 0 until m) {
        dp[i][0] = 1
    }

    for (j in 0 until n) {
        dp[0][j] = 1
    }

    // Fill in the rest of the array using the recurrence relation: dp[i][j] = dp[i-1][j] + dp[i][j-1]
    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }

    // The result is stored in the bottom-right cell of the array
    return dp[m - 1][n - 1]
}