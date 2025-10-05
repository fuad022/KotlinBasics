package com.example.kotlinbasics

fun main() {
    val graph = GraphDFS(6)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 4)
    graph.addEdge(3, 5)
    graph.addEdge(4, 5)

    println("Depth First Traversal starting from vertex 0:")
    graph.dfs(0)
}

class GraphDFS(private val vertices: Int) {
    private val adjacencyList = Array<MutableList<Int>>(vertices) { mutableListOf() }

    fun addEdge(source: Int, destination: Int) {
        adjacencyList[source].add(destination)
    }

    fun dfs(startVertex: Int) {
        val visited = BooleanArray(vertices)
        dfsUtil(startVertex, visited)
    }

    private fun dfsUtil(vertex: Int, visited: BooleanArray) {
        visited[vertex] = true
        print("$vertex")

        for (adjacentVertex in adjacencyList[vertex]) {
            if (!visited[adjacentVertex]) {
                dfsUtil(adjacentVertex, visited)
            }
        }
    }
}