package com.example.kotlinbasics

import kotlin.math.exp

fun main() {
    val x = arrayOf(
        doubleArrayOf(1.0, 2.0),
        doubleArrayOf(2.0, 3.0),
        doubleArrayOf(3.0, 4.0),
        doubleArrayOf(4.0, 5.0),
        doubleArrayOf(5.0, 6.0)
    )
    val y = doubleArrayOf(0.0, 0.0, 1.0, 1.0, 1.0)

    val logisticRegression = LogisticRegression(learningRate = 0.01, iterations = 1000)
    logisticRegression.fit(x, y)

    val newX = arrayOf(
        doubleArrayOf(1.0, 3.0),
        doubleArrayOf(2.0, 4.0),
        doubleArrayOf(3.0, 5.0)
    )
    val predictions = logisticRegression.predict(newX)
    println("Predictions: ${predictions.joinToString(", ")}")
}

class LogisticRegression(private val learningRate: Double, private val iterations: Int) {
    private var weights: DoubleArray? = null

    fun fit(x: Array<DoubleArray>, y: DoubleArray) {
        val numRows = x.size
        val numCols = x[0].size
        weights = DoubleArray(numCols) { 0.0 }

        repeat(iterations) {
            val predictions = mutableListOf<Double>()
            for (i in 0 until numRows) {
                val prediction = sigmoid(dotProduct(x[i], weights!!))
                predictions.add(prediction)
                val error = y[i] - prediction
                for (j in 0 until numCols) {
                    weights!![j] += learningRate * error * x[i][j]
                }
            }
        }
    }

    fun predict(x: Array<DoubleArray>): DoubleArray {
        require(weights != null) { "Model not trained yet" }
        val numRows = x.size
        val predictions = DoubleArray(numRows)
        for (i in 0 until numRows) {
            predictions[i] = sigmoid(dotProduct(x[i], weights!!))
        }
        return predictions
    }

    private fun sigmoid(z: Double): Double {
        return 1.0 / (1.0 + exp(-z))
    }

    private fun dotProduct(a: DoubleArray, b: DoubleArray): Double {
        require(a.size == b.size) { "Arrays must be of the same length" }
        var dotProduct = 0.0
        for (i in a.indices) {
            dotProduct += a[i] * b[i]
        }
        return dotProduct
    }
}