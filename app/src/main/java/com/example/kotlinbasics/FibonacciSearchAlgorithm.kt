package com.example.kotlinbasics

fun main() {

}

fun fibonacciSearch(arr: IntArray, x: Int): Int {
    val n = arr.size
    var fib2 = 0
    var fib1 = 1
    var fib = fib1 + fib2

    while (fib < n) {
        fib2 = fib1
        fib1 = fib
        fib = fib1 + fib2
    }

    var offset = -1
    while (fib > 1) {
        val i = kotlin.math.min(offset + fib2, n - 1)
        if (arr[i] < x) {
            fib = fib1
            fib1 = fib2
            fib2 = fib - fib1
            offset = i
        } else if (arr[i] > x) {
            fib = fib2
            fib1 -= fib2
            fib2 = fib - fib1
        }
    }

    if (fib1 == 1 && arr[offset + 1] == x)
        return offset + 1

    return -1
}