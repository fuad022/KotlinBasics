package com.example.kotlinbasics

import kotlin.math.max

fun main() {
    val price = intArrayOf(1, 5, 8, 9, 10, 17, 17, 20)
    val n = price.size

    val maxProfit = cutRod(price, n)
    println("Maximum Obtainable Value is $maxProfit")
}

fun cutRod(price: IntArray, n: Int): Int {
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        var maxVal = Int.MIN_VALUE
        for (j in 0 until i) {
            maxVal = max(maxVal, price[j] + dp[i - j - 1])
        }
        dp[i] = maxVal
    }

    return dp[n]
}