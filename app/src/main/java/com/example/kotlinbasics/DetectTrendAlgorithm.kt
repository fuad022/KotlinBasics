package com.example.kotlinbasics

fun main() {
    val data = listOf(10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0, 24.0, 26.0, 28.0)
    val windowSize = 3
    val trend = detectTrend(data, windowSize)
    println("Trend: $trend")
}

fun calculateMovingAverage(data: List<Double>, windowSize: Int): List<Double> {
    val movingAverages = mutableListOf<Double>()

    for (i in windowSize - 1 until data.size) {
        var sum = 0.0
        for (j in i downTo i - windowSize + 1) {
            sum += data[j]
        }
        val average = sum / windowSize
        movingAverages.add(average)
    }

    return movingAverages
}

fun detectTrend(data: List<Double>, windowSize: Int): String {
    val movingAverages = calculateMovingAverage(data, windowSize)
    val lastMA = movingAverages.last()
    val secondLastMA = movingAverages[movingAverages.size - 2]

    return when {
        lastMA > secondLastMA -> "Upward trend"
        lastMA < secondLastMA -> "Downward trend"
        else -> "No clear trend"
    }
}