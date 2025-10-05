package com.example.kotlinbasics

fun main() {
    val graph = GraphVC(5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(3, 4)

    val vertexCover = graph.vertexCover()
    println("Vertex Cover: $vertexCover")
}

class GraphVC(private val numVertices: Int) {
    private val adjacencyMatrix: Array<BooleanArray> =
        Array(numVertices) { BooleanArray(numVertices) }

    fun addEdge(u: Int, v: Int) {
        adjacencyMatrix[u][v] = true
        adjacencyMatrix[v][u] = true
    }

    fun vertexCover(): Set<Int> {
        val vertices = mutableSetOf<Int>()
        val visited = BooleanArray(numVertices)
        for (i in 0 until numVertices) {
            if (!visited[i]) {
                val adjacentVertices = adjacencyMatrix[i]
                for (j in adjacentVertices.indices) {
                    if (!visited[j] && adjacentVertices[j]) {
                        vertices.add(i)
                        vertices.add(j)
                        visited[i] = true
                        visited[j] = true
                        break
                    }
                }
            }
        }
        return vertices
    }
}