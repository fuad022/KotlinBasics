package com.example.kotlinbasics

fun main() {
    val graph = DAG(6)
    graph.addEdge(5, 2)
    graph.addEdge(5, 0)
    graph.addEdge(4, 0)
    graph.addEdge(4, 1)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)

    val result = graph.topologicalSort()
    println("Topological ordering: $result")
}

class DAG(private val numVertices: Int) {
    private val adjacencyList: MutableList<MutableList<Int>> =
        MutableList(numVertices) { mutableListOf() }

    fun addEdge(from: Int, to: Int) {
        adjacencyList[from].add(to)
    }

    fun topologicalSort(): List<Int> {
        val visited = BooleanArray(numVertices) { false }
        val stack = mutableListOf<Int>()

        fun dfs(vertex: Int) {
            visited[vertex] = true
            for (adjacentVertex in adjacencyList[vertex]) {
                if (!visited[adjacentVertex]) {
                    dfs(adjacentVertex)
                }
            }
            stack.add(vertex)
        }

        for (vertex in 0 until numVertices) {
            if (!visited[vertex]) {
                dfs(vertex)
            }
        }

        return stack.reversed()
    }
}