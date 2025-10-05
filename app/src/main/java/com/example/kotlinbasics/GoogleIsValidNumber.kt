package com.example.kotlinbasics

fun main() {
    val numberToCheck = 42.5
    val minValue = 0.0
    val maxValue = 100.0

    if (isValidNumber(numberToCheck, minValue, maxValue)) {
        println("$numberToCheck is a valid number.")
    } else {
        println("$numberToCheck is not a valid number.")
    }
}

fun isValidNumber(number: Double, minValue: Double, maxValue: Double): Boolean {
    return number in minValue..maxValue
}