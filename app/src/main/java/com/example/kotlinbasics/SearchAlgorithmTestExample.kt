package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val x = 5
    val index = jumpSearch(arr, x)
    if (index != -1) {
        println("Element $x is resent at index $index")
    } else {
        println("Element $x is not present in the array")
    }
}

fun jumpSearch(arr: IntArray, x: Int): Int {
    val n = arr.size
    var step = Math.floor(Math.sqrt(n.toDouble())).toInt()
    var prev = 0

    while (arr[Math.min(step, n) - 1] < x) {
        prev = step
        step += Math.floor(Math.sqrt(n.toDouble())).toInt()
        if (prev >= n)
            return -1
    }

    while (arr[prev] < x) {
        prev++
        if (prev == Math.min(step, n))
            return -1
    }

    return if (arr[prev] == x) prev else -1
}