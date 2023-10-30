package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    println("Original array: ${arr.joinToString()}")
    combSort(arr)
    println("Sorted array: ${arr.joinToString()}")
}

fun combSort(arr: IntArray) {
    val n = arr.size
    var gap = n
    var swapped = true

    while (gap != 1 || swapped) {
        gap = getNextGap(gap)

        swapped = false

        for (i in 0 until n - gap) {
            if (arr[i] > arr[i + gap]) {
                // Swap arr[i] and arr[i+gap]
                val temp = arr[i]
                arr[i] = arr[i + gap]
                arr[i + gap] = temp
                swapped = true
            }
        }
    }
}

fun getNextGap(gap: Int): Int {
    // The shrink factor is typically 1.3 in Comb Sort
    val shrink = 10 / 13
    val nextGap = (gap * shrink).toInt()
    return if (nextGap < 1) 1 else nextGap
}