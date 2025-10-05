package com.example.kotlinbasics

fun main() {
    val graph = GraphMC(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 3)

    val numColors = 3
    graph.graphColoring(numColors)
}

class GraphMC(private val numVertices: Int) {
    private val adjacencyMatrix: Array<IntArray> = Array(numVertices) { IntArray(numVertices) }

    fun addEdge(vertex1: Int, vertex2: Int) {
        adjacencyMatrix[vertex1][vertex2] = 1
        adjacencyMatrix[vertex2][vertex1] = 1
    }

    fun printSolution(coloring: IntArray) {
        println("Vertex Color")
        for (i in 0 until numVertices) {
            println("$i ${coloring[i]}")
        }
    }

    fun isSafe(vertex: Int, color: Int, result: IntArray): Boolean {
        for (i in 0 until numVertices) {
            if (adjacencyMatrix[vertex][i] == 1 && color == result[i]) {
                return false
            }
        }
        return true
    }

    fun graphColoringUtil(numColors: Int, result: IntArray, vertex: Int): Boolean {
        if (vertex == numVertices) {
            return true
        }

        for (color in 1..numColors) {
            if (isSafe(vertex, color, result)) {
                result[vertex] = color
                if (graphColoringUtil(numColors, result, vertex + 1)) {
                    return true
                }
                result[vertex] = 0
            }
        }
        return false
    }

    fun graphColoring(numColors: Int) {
        val result = IntArray(numVertices)
        if (!graphColoringUtil(numColors, result, 0)) {
            println("Solution does not exist")
            return
        }
        printSolution(result)
    }
}