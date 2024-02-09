package com.example.kotlinbasics

import kotlin.math.min

class TSP {
    private val INFINITY = Int.MAX_VALUE

    fun tsp(graph: Array<IntArray>): Int {
        val n = graph.size
        val visited = BooleanArray(n)
        visited[0] = true
        return tspUtil(graph, visited, 0, 1, 0, INFINITY)
    }

    private fun tspUtil(
        graph: Array<IntArray>, visited: BooleanArray, currentPos: Int, count: Int, cost: Int,
        ans: Int
    ): Int {
        var minCost = ans
        if (count == graph.size && graph[currentPos][0] != 0) {
            return min(minCost, cost + graph[currentPos][0])
        }

        for (i in 0 until graph.size) {
            if (!visited[i] && graph[currentPos][i] != 0) {
                visited[i] = true
                val newCost =
                    tspUtil(graph, visited, i, count + 1, cost + graph[currentPos][i], minCost)
                minCost = min(ans, newCost)
                visited[i] = false
            }
        }

        return minCost
    }
}

fun main() {
    val tsp = TSP()
    val graph = arrayOf(
        intArrayOf(0, 10, 15, 20),
        intArrayOf(10, 0, 35, 25),
        intArrayOf(15, 35, 0, 30),
        intArrayOf(20, 25, 30, 0)
    )

    val minCost = tsp.tsp(graph)
    println("Minimum Cost: $minCost")
}