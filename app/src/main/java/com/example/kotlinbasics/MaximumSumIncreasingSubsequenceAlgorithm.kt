package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 101, 2, 3, 100, 4, 5)
    val result = maxSumIncreasingSubsequence(arr)
    println("Maximum Sum Increasing Subsequence: $result")
}

fun maxSumIncreasingSubsequence(arr: IntArray): Int {
    val n = arr.size
    val msis = IntArray(n)

    // Initialize the msis array with the input array values
    for (i in 0 until n) {
        msis[i] = arr[i]
    }

    // Compute the maximum sum increasing subsequence
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                msis[i] = msis[j] + arr[i]
            }
        }
    }

    // Find the maximum value in the msis array
    var maxSum = Int.MIN_VALUE
    for (i in 0 until n) {
        if (msis[i] > maxSum) {
            maxSum = msis[i]
        }
    }

    return maxSum
}