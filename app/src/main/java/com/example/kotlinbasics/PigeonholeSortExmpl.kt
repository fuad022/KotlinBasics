package com.example.kotlinbasics

fun main() {
    val arr = intArrayOf(8, 3, 2, 7, 4, 6, 8)

    println("Исходный массив: ${arr.joinToString()}")
    pigeonholeSort(arr)
    println("Отсортированный массив: ${arr.joinToString()}")
}

fun pigeonholeSort(arr: IntArray) {
    val max = arr.maxOrNull() ?: 0
    val min = arr.minOrNull() ?: 0

    val countArray = IntArray(max - min + 1)

    for (value in arr) {
        countArray[value - min]++
    }

    var index = 0
    for (i in min..max) {
        while (countArray[i - min] > 0) {
            arr[index] = i
            index++
            countArray[i - min]--
        }
    }
}