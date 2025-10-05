package com.example.kotlinbasics

import java.util.PriorityQueue

class GraphD(private val numVertices: Int) {
    private val adjacencyList: MutableList<MutableList<Pair<Int, Int>>> =
        MutableList(numVertices) { mutableListOf() }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        adjacencyList[source].add(Pair(destination, weight))
    }

    fun dijkstra(startingVertex: Int): IntArray {
        val distances = IntArray(numVertices) { Int.MAX_VALUE }
        val visited = BooleanArray(numVertices)
        distances[startingVertex] = 0

        val priorityQueue =
            PriorityQueue<Pair<Int, Int>>(Comparator { a, b -> a.second - b.second })
        priorityQueue.add(Pair(startingVertex, 0))

        while (priorityQueue.isNotEmpty()) {
            val vertex = priorityQueue.remove().first
            if (visited[vertex]) continue
            visited[vertex] = true

            for (neighbor in adjacencyList[vertex]) {
                val (nextVertex, weight) = neighbor
                val distance = distances[vertex] + weight
                if (distance < distances[nextVertex]) {
                    distances[nextVertex] = distance
                    priorityQueue.add(Pair(nextVertex, distance))
                }
            }
        }

        return distances
    }
}

fun main() {
    val graph = GraphD(6)
    graph.addEdge(0, 1, 5)
    graph.addEdge(0, 2, 3)
    graph.addEdge(1, 3, 6)
    graph.addEdge(1, 2, 2)
    graph.addEdge(2, 4, 4)
    graph.addEdge(2, 5, 2)
    graph.addEdge(2, 3, 7)
    graph.addEdge(3, 4, -1)
    graph.addEdge(4, 5, -2)

    val distances = graph.dijkstra(0)
    println("Shortest distances from vertex 0:")
    for (i in distances.indices) {
        println("Vertex $i: ${distances[i]}")
    }
}