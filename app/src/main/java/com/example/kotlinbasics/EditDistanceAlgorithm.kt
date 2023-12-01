package com.example.kotlinbasics

fun main() {
    val str1 = "kitten"
    val str2 = "sitting"

    val distance = editDistance(str1, str2)

    println("Edit Distance between '$str1' and '$str2' is: $distance")
}

fun minOfThree(a: Int, b: Int, c: Int): Int {
    return minOf(minOf(a, b), c)
}

fun editDistance(str1: String, str2: String): Int {
    val m = str1.length
    val n = str2.length

    // Create a 2D array to store the edit distance
    val dp = Array(m + 1) { IntArray(n + 1) }

    // Initialize the
    for (i in 0..m) {
        for (j in 0..n) {
            when {
                i == 0 -> dp[i][j] = j
                j == 0 -> dp[i][j] = i
                else -> dp[i][j] = 0
            }
        }
    }

    // Fill in the rest of the array using dynamic programming
    for (i in 1..m) {
        for (j in 1..n) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = 1 + minOfThree(
                    dp[i - 1][j],       // Deletion
                    dp[i][j - 1],       // Insertion
                    dp[i - 1][j - 1]    // Substitution
                )
            }
        }
    }

    // The bottom-right cell of the array contains the final edit distance
    return dp[m][n]
}