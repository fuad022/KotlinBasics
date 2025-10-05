package com.example.kotlinbasics

fun main() {
    val input = "abca"
    val result = minDeletionsToMakePalindrome(input)
    println("Minimum deletions to make '$input' a palindrome: $result")
}

fun minDeletionsToMakePalindrome(str: String): Int {
    val n = str.length
    val dp = Array(n) { IntArray(n) }

    // Initialize the dp array for strings of length 1
    for (i in 0 until n) {
        dp[i][i] = 1
    }

    // Build the dp array for longer strings
    for (len in 2..n) {
        for (i in 0 until n - len + 1) {
            val j = i + len - 1
            if (str[i] == str[j] && len == 2) {
                dp[i][j] = 2
            } else if (str[i] == str[j]) {
                dp[i][j] = dp[i + 1][j - 1] + 2
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i + 1][j])
            }
        }
    }

    // The length of the longest palindromic subsequence
    val longestPalindromicSubsequence = dp[0][n - 1]

    // Minimum deletions to make the string a palindrome
    val minDeletions = n - longestPalindromicSubsequence
    return minDeletions
}