package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val graph = GraphF(6)

    graph.addEdge(0, 1, 5)
    graph.addEdge(0, 2, 2)
    graph.addEdge(1, 3, 4)
    graph.addEdge(2, 1, 1)
    graph.addEdge(2, 3, 7)
    graph.addEdge(3, 4, 3)
    graph.addEdge(4, 0, 1)
    graph.addEdge(4, 5, 2)

    graph.dijkstra(0)
}

class GraphF {
    private val vertices: Int
    private val adjacencyList: MutableMap<Int, MutableList<NodeF>>

    constructor(vertices: Int) {
        this.vertices = vertices
        adjacencyList = mutableMapOf()
        for (i in 0 until vertices) {
            adjacencyList[i] = mutableListOf()
        }
    }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        val node = NodeF(destination, weight)
        adjacencyList[source]?.add(node)
    }

    fun dijkstra(startVertex: Int) {
        val priorityQueue = PriorityQueue<NodeF>(Comparator.comparingInt { it.weight })
        val visited = BooleanArray(vertices)
        val distance = IntArray(vertices) { Int.MAX_VALUE }

        distance[startVertex] = 0
        priorityQueue.offer(NodeF(startVertex, 0))

        while (!priorityQueue.isEmpty()) {
            val currentVertex = priorityQueue.poll().vertex

            if (visited[currentVertex]) {
                continue
            }

            visited[currentVertex] = true

            for (edge in adjacencyList[currentVertex] ?: emptyList()) {
                val newDistance = distance[currentVertex] + edge.weight

                if (newDistance < distance[edge.vertex]) {
                    distance[edge.vertex] = newDistance
                    priorityQueue.offer(NodeF(edge.vertex, newDistance))
                }
            }
        }


        for (i in 0 until vertices) {
            println("Shortest distance from $startVertex to $i is ${distance[i]}")
        }
    }

    data class NodeF(val vertex: Int, val weight: Int)
}