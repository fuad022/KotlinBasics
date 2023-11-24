package com.example.kotlinbasics

import kotlin.random.Random

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 5, 9),
        intArrayOf(10, 11, 13),
        intArrayOf(12, 13, 15)
    )
    val k = 8
    val result = kthSmallest(matrix, k)
    println("The $k smallest element is: $result")

    val randomNumber = Random.nextInt(1, 21)
    println("$randomNumber")
}

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val rows = matrix.size
    val cols = matrix[0].size

    var low = matrix[0][0]
    var high = matrix[rows - 1][cols - 1]

    while (low < high) {
        val mid = low + (high - low) / 2
        val count = countLessOrEqual(matrix, mid)
        if (count < k) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}

fun countLessOrEqual(matrix: Array<IntArray>, target: Int): Int {
    val rows = matrix.size
    val cols = matrix[0].size

    var count = 0
    var row = rows - 1
    var col = 0

    while (row >= 0 && col < cols) {
        if (matrix[row][col] <= target) {
            count += row + 1
            col++
        } else {
            row--
        }
    }

    return count
}