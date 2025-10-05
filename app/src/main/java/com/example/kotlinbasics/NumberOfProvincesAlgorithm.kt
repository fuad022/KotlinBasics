package com.example.kotlinbasics

fun main() {
    val g = GraphNOP(4)
    g.addEdge(0, 1)
    g.addEdge(1, 2)
    g.addEdge(3, 3)

    val provinces = g.countProvinces()
    println("Number of provinces: $provinces")
}

class GraphNOP(private val n: Int) {
    private val adjacencyList = Array(n) { mutableListOf<Int>() }

    fun addEdge(u: Int, v: Int) {
        adjacencyList[u].add(v)
        adjacencyList[v].add(u)
    }

    fun countProvinces(): Int {
        val visited = BooleanArray(n)
        var provinces = 0

        for (i in 0 until n) {
            if (!visited[i]) {
                provinces++
                dfs(i, visited)
            }
        }

        return provinces
    }

    private fun dfs(node: Int, visited: BooleanArray) {
        visited[node] = true

        for (neighbor in adjacencyList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited)
            }
        }
    }
}