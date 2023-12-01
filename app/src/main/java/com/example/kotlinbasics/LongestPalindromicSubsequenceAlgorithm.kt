package com.example.kotlinbasics

fun main() {
    val input = "babad"
    val result = longestPalindromeSubsequence(input)
    println("Length of Longest Palindromic Subsequence: $result")

    //////////////

    val n = 3
    val dp = Array(n) { IntArray(n) }

    // Заполнение массива значениями (в данном примере заполним его индексами)
    var count = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            dp[i][j] = count++
        }
    }

    // Вывод массива на экран
    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${dp[i][j]}")
        }
        println() // Переход на новую строку после каждой строки массива
    }
}

fun longestPalindromeSubsequence(input: String): Int {
    val n = input.length
    val dp = Array(n) { IntArray(n) }

    // All substrings of length 1 are palindromes
    for (i in 0 until n) {
        dp[i][i] = 1
    }

    // Build the table in a bottom-up manner
    for (cl in 2..n) {
        for (i in 0 until n - cl + 1) {
            val j = i + cl - 1
            if (input[i] == input[j] && cl == 2) {
                dp[i][j] = 2
            } else if (input[i] == input[j]) {
                dp[i][j] = dp[i + 1][j - 1] + 2
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i + 1][j])
            }
        }
    }

    // The length of the longest palindromic subsequence is stored in dp[0][n-1]
    return dp[0][n - 1]
}