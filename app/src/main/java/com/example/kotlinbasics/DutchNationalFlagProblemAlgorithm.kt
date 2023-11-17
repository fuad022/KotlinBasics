package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(1, 0, 2, 1, 0, 2, 1, 0, 2)
    dutchNationalFlag(arr)
    println("Sorted Array: ${arr.joinToString()}")
}

fun dutchNationalFlag(arr: IntArray) {
    var low = 0
    var high = arr.size - 1
    var mid = 0

    while (mid <= high) {
        when {
            arr[mid] == 0 -> {
                swapDNF(arr, low, mid)
                low++
                mid++
            }

            arr[mid] == 1 -> {
                mid++
            }

            arr[mid] == 2 -> {
                swapDNF(arr, mid, high)
                high--
            }
        }
    }
}

fun swapDNF(arr: IntArray, a: Int, b: Int) {
    val temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
}