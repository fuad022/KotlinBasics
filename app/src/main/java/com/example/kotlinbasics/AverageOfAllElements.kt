package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5) // your data array

    val average = array.average()

    for (element in array) {
        val comparison = when {
            element > average -> "greater than"
            element < average -> "less than"
            else -> "equa to"
        }
        println("Element $element is $comparison the average $average")
    }
}