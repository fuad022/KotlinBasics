package com.example.kotlinbasics

import java.lang.StringBuilder

fun main() {
    val str1 = "AGGTAB"
    val str2 = "GXTXAYB"
    println("Longest Common Subsequence: ${longestCommonSubsequence(str1, str2)}")
}

fun longestCommonSubsequence(str1: String, str2: String): String {
    val m = str1.length
    val n = str2.length

    val dp = Array(m + 1) { IntArray(n + 1) }

    // Build DP table
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            } else if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    var i = m
    var j = n
    val lcs = StringBuilder()
    while (i > 0 && j > 0) {
        when {
            str1[i - 1] == str2[j - 1] -> {
                lcs.append(str1[i - 1])
                i--
                j--
            }

            dp[i - 1][j] > dp[i][j - 1] -> i--
            else -> j--
        }
    }

    return lcs.reverse().toString()
}