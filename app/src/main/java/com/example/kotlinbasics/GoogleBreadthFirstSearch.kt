package com.example.kotlinbasics

import java.util.*
import java.util.LinkedList

class GraphGBFS(private val vertices: Int) {
    private val adjacencyList: Array<MutableList<Int>> = Array(vertices) { mutableListOf() }

    fun addEdge(u: Int, v: Int) {
        adjacencyList[u].add(v)
    }

    fun bfs(startVertex: Int) {
        val visited = BooleanArray(vertices)
        val queue: Queue<Int> = LinkedList()

        visited[startVertex] = true
        queue.add(startVertex)

        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            print("$currentVertex ")

            for (neighbor in adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
    }
}

fun main() {
    val graph = GraphGBFS(6)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 4)
    graph.addEdge(3, 4)
    graph.addEdge(3, 5)
    graph.addEdge(4, 5)

    println("Breadth-First Search starting from vertex 0:")
    graph.bfs(0)
}