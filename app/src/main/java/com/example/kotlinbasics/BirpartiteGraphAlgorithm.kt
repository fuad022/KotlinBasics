package com.example.kotlinbasics

fun main() {
    val graph = GraphBG(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 3)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)

    if (graph.isBipartite()) {
        println("The graph is bipartite.")
    } else {
        println("The graph is not bipartite.")
    }
}

class GraphBG(private val vertexCount: Int) {
    private val adjacencyList: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun addEdge(u: Int, v: Int) {
        adjacencyList.computeIfAbsent(u) { mutableListOf() }.add(v)
        adjacencyList.computeIfAbsent(v) { mutableListOf() }.add(u)
    }

    fun isBipartite(): Boolean {
        val colors = IntArray(vertexCount) { -1 }

        for (i in 0 until vertexCount) {
            if (colors[i] == -1 && !isBipartiteUtil(i, colors, 0)) {
                return false
            }
        }

        return true
    }

    private fun isBipartiteUtil(v: Int, colors: IntArray, color: Int): Boolean {
        colors[v] = color

        for (neighbor in adjacencyList[v] ?: emptyList()) {
            if (colors[neighbor] == -1) {
                if (!isBipartiteUtil(neighbor, colors, 1 - color)) {
                    return false
                }
            } else if (colors[neighbor] == color) {
                return false
            }
        }

        return false
    }
}