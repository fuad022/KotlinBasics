package com.example.kotlinbasics

fun main() {
    val houses = intArrayOf(6, 7, 1, 30, 8, 2, 4)
    val result = maxStolenValue(houses)
    println("Maximum stolen value: $result")
}

fun maxStolenValue(houses: IntArray): Int {
    val n = houses.size
    if (n == 0) return 0
    if (n == 1) return houses[0]

    val dp = IntArray(n)
    dp[0] = houses[0]
    dp[1] = maxOf(houses[0], houses[1])

    for (i in 2 until n) {
        dp[i] = maxOf(dp[i - 1], dp[i - 2] + houses[i])
    }

    return dp[n - 1]
}