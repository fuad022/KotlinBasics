package com.example.kotlinbasics

import java.lang.IllegalArgumentException
import kotlin.math.sqrt

fun main() {
    val data = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val result = standartDeviation(data)
    println("Standart Deviation: $result")
}

fun standartDeviation(data: List<Double>): Double {
    val size = data.size
    if (size <= 1) {
        throw IllegalArgumentException("Standart deviation requires at least two data points")
    }

    val mean = data.average()
    val variance = data.map { (it - mean) * (it - mean) }.sum() / size
    return sqrt(variance)
}