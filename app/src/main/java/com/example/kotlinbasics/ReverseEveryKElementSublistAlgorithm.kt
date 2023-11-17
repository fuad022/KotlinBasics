package com.example.kotlinbasics

fun main() {
    val originalList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val k = 3

    val reversedList = reverseKElementSublists(originalList, k)

    println("Original List: $originalList")
    println("Reversed List with $k-element sub-lists: $reversedList")
}

fun <T> reverseKElementSublists(inputList: List<T>, k: Int): List<T> {
    val result = inputList.toMutableList()

    var i = 0
    while (i < result.size) {
        val endIndex = minOf(i + k - 1, result.size - 1)
        reverseSublist(result, i, endIndex)
        i += k
    }

    return result
}

fun <T> reverseSublist(list: MutableList<T>, start: Int, end: Int) {
    var i = start
    var j = end
    while (i < j) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
        i++
        j--
    }
}