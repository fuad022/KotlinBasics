package com.example.kotlinbasics

fun main() {
    val coins = intArrayOf(1, 2, 5)
    val amount = 11

    val ways = coinChangeWays(coins, amount)

    println("Number of ways to make change for $amount is: $ways")
}

fun coinChangeWays(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1)
    dp[0] = 1

    for (coin in coins) {
        for (i in coin until dp.size) {
            dp[i] += dp[i - coin]
        }
    }

    return dp[amount]
}