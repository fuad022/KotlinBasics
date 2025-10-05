package com.example.kotlinbasics

fun main() {
    val array1 = intArrayOf(1, 2, 3, 4, 5)
    val array2 = intArrayOf(3, 4, 5, 6, 7)
    val target = 8
    val pairs = saddlebackSearch(array1, array2, target)
    if (pairs.isEmpty()) {
        println("No pairs found.")
    } else {
        println("Pairs found:")
        pairs.forEach { pair ->
            println("${pair.first}, ${pair.second}")
        }
    }
}

fun saddlebackSearch(array1: IntArray, array2: IntArray, target: Int): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()
    var left = 0
    var right = array2.size - 1

    for (i in array1.indices) {
        while (left < array2.size && right >= 0) {
            val sum = array1[i] + array2[right]
            when {
                sum == target -> {
                    result.add(Pair(array1[i], array2[right]))
                    left++
                    right--
                }

                sum < target -> left++
                else -> right--
            }
        }
    }
    return result
}