package com.example.kotlinbasics

fun main() {
    // Example graph represented by edges
    val edges = listOf(
        EdgeMST(0, 1, 4),
        EdgeMST(0, 7, 8),
        EdgeMST(1, 2, 8),
        EdgeMST(1, 7, 11),
        EdgeMST(2, 3, 7),
        EdgeMST(2, 8, 2),
        EdgeMST(2, 5, 4),
        EdgeMST(3, 4, 9),
        EdgeMST(3, 5, 14),
        EdgeMST(4, 5, 10),
        EdgeMST(5, 6, 2),
        EdgeMST(6, 7, 1),
        EdgeMST(6, 8, 1),
        EdgeMST(7, 8, 7)
    )

    val kruskalMST = KruskalMST(edges)
    val minimumSpanningTree = kruskalMST.findMST()

    println("Minimum Spanning Tree")
    for (edge in minimumSpanningTree) {
        println("${edge.source} - ${edge.destination} : ${edge.weight}")
    }
}

data class EdgeMST(val source: Int, val destination: Int, val weight: Int)

class KruskalMST(private val graph: List<EdgeMST>) {
    private val parent = mutableMapOf<Int, Int>()

    init {
        // Initialize each vertex as its own parent
        for (edge in graph) {
            parent[edge.source] = edge.source
            parent[edge.destination] = edge.destination
        }
    }

    fun findMST(): List<EdgeMST> {
        val mst = mutableListOf<EdgeMST>()
        val sortedEdges = graph.sortedBy { it.weight }

        for (edge in sortedEdges) {
            val root1 = findRoot(edge.source)
            val root2 = findRoot(edge.destination)

            if (root1 != root2) {
                mst.add(edge)
                // Union the two vertices
                parent[root1] = root2
            }
        }

        return mst
    }

    private fun findRoot(vertex: Int): Int {
        var current = vertex
        while (parent[current] != current) {
            current = parent[current]!!
        }
        return current
    }
}