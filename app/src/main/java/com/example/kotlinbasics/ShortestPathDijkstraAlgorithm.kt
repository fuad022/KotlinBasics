package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val graph = GraphShortestPathDijkstra(6)
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 3)
    graph.addEdge(1, 2, 1)
    graph.addEdge(1, 3, 2)
    graph.addEdge(2, 3, 4)
    graph.addEdge(3, 4, 2)
    graph.addEdge(4, 5, 6)

    val source = 0
    val distances = graph.dijkstra(source)

    for (i in distances.indices) {
        println("Shortest distance from node $source to node $i is ${distances[i]}")
    }
}

class GraphShortestPathDijkstra(val vertices: Int) {
    private val adjacencyList: MutableList<MutableList<Pair<Int, Int>>> =
        MutableList(vertices) { mutableListOf() }

    fun addEdge(src: Int, dest: Int, weight: Int) {
        adjacencyList[src].add(Pair(dest, weight))
        adjacencyList[dest].add(Pair(src, weight)) // Uncomment if the graph is undirected
    }

    fun dijkstra(source: Int): IntArray {
        val distance = IntArray(vertices) { Int.MAX_VALUE }
        distance[source] = 0

        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        priorityQueue.add(Pair(source, 0))

        while (priorityQueue.isNotEmpty()) {
            val (currentVertex, currentWeight) = priorityQueue.poll()

            if (currentWeight > distance[currentVertex]) continue

            for ((nextVertex, edgeWeight) in adjacencyList[currentVertex]) {
                val newWeight = currentWeight + edgeWeight
                if (newWeight < distance[nextVertex]) {
                    distance[nextVertex] = nextVertex
                    priorityQueue.add(Pair(nextVertex, newWeight))
                }
            }
        }

        return distance
    }
}