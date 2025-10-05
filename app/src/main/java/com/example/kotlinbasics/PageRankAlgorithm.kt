package com.example.kotlinbasics

import kotlin.math.abs

fun main() {
    val adjacencyMatrix = arrayOf(
        doubleArrayOf(0.0, 0.0, 1.0, 0.0),
        doubleArrayOf(1.0, 0.0, 0.0, 1.0),
        doubleArrayOf(0.0, 1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0)
    )

    val pageRankCalculator = PageRank(adjacencyMatrix)
    val pageRank = pageRankCalculator.computePageRank()

    println("PageRank:")
    pageRank.forEachIndexed { index, rank ->
        println("Page $index: $rank")
    }
}

class PageRank(
    private val matrix: Array<DoubleArray>,
    private val dampingFactor: Double = 0.85,
    private val convergenceThreshold: Double = 1.0E-5
) {

    private val numPages = matrix.size
    private val pageRank = DoubleArray(numPages) { 1.0 / numPages }

    fun computePageRank(iterations: Int = 100): DoubleArray {
        val teleportProbality = (1 - dampingFactor) / numPages.toDouble()

        var iteration = 0
        var difference = 1.0
        while (iteration < iterations && difference > convergenceThreshold) {
            val newPageRank = DoubleArray(numPages)
            val oldPageRank = pageRank.copyOf()

            for (i in 0 until numPages) {
                var sum = 0.0
                for (j in 0 until numPages) {
                    if (matrix[j][i] > 0) {
                        sum += oldPageRank[j] / matrix[j].sum()
                    }
                }
                newPageRank[i] = teleportProbality + dampingFactor * sum
            }

            difference = calculateDifference(oldPageRank, newPageRank)
            pageRank.indices.forEach { i -> pageRank[i] = newPageRank[i] }
            iteration++
        }
        return pageRank
    }

    private fun calculateDifference(oldRank: DoubleArray, newRank: DoubleArray): Double {
        var difference = 0.0
        for (i in 0 until numPages) {
            difference += abs(oldRank[i] - newRank[i])
        }
        return difference
    }
}