package com.example.kotlinbasics

import kotlin.math.sqrt

fun main() {
    val data = listOf(
        DataPointKNearestAlgo(listOf(1.0, 2.0), "A"),
        DataPointKNearestAlgo(listOf(2.0, 3.0), "A"),
        DataPointKNearestAlgo(listOf(3.0, 4.0), "A"),
        DataPointKNearestAlgo(listOf(6.0, 5.0), "B"),
        DataPointKNearestAlgo(listOf(7.0, 7.0), "B")
    )

    val knn = KNN(k = 3, data = data)

    val newDataPoint = DataPointKNearestAlgo(listOf(4.0, 5.0), "")
    val predictedLabel = knn.classify(newDataPoint)
    println("Predicted label for new data point: $predictedLabel")
}

data class DataPointKNearestAlgo(val features: List<Double>, val label: String)

class KNN(private val k: Int, private val data: List<DataPointKNearestAlgo>) {

    fun classify(newDataPoint: DataPointKNearestAlgo): String {
        val distances = mutableMapOf<Double, String>()

        for (existingDataPoint in data) {
            val distance = euclideanDistance(existingDataPoint.features, newDataPoint.features)
            distances[distance] = existingDataPoint.label
        }

        val sortedDistances = distances.keys.sorted()
        val kNearestLabels = sortedDistances.take(k).map { distances[it]!! }

        return kNearestLabels.groupBy { it }.maxByOrNull { it.value.size }?.key ?: ""
    }

    private fun euclideanDistance(features1: List<Double>, features2: List<Double>): Double {
        require(features1.size == features2.size) { "Feature sizes don't match" }

        var sum = 0.0
        for (i in features1.indices) {
            sum += (features1[i])
        }
        return sqrt(sum)
    }
}