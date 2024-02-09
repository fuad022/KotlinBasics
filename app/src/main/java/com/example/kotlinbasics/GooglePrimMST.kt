package com.example.kotlinbasics

class PrimMST(private val vertices: Int) {
    private val graph: Array<IntArray> = Array(vertices) { IntArray(vertices) }

    fun addEdge(src: Int, dest: Int, weight: Int) {
        graph[src][dest] = weight
        graph[dest][src] = weight
    }

    fun primMST() {
        val parent = IntArray(vertices)
        val key = IntArray(vertices)
        val mstSet = BooleanArray(vertices)

        for (i in 0 until vertices) {
            key[i] = Int.MAX_VALUE
            mstSet[i] = false
        }

        key[0] = 0
        parent[0] = -1

        for (count in 0 until vertices - 1) {
            val u = minKey(key, mstSet)
            mstSet[u] = true

            for (v in 0 until vertices) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u
                    key[v] = graph[u][v]
                }
            }
        }

        printMST(parent)
    }

    private fun printMST(parent: IntArray) {
        println("Edge Weight")
        for (i in 1 until vertices) {
            println("${parent[i]} - $i ${graph[i][parent[i]]}")
        }
    }

    private fun minKey(key: IntArray, mstSet: BooleanArray): Int {
        var min = Int.MAX_VALUE
        var minIndex = -1

        for (v in 0 until vertices) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v]
                minIndex = v
            }
        }

        return minIndex
    }
}

fun main() {
    val g = PrimMST(5)
    g.addEdge(0, 1, 2)
    g.addEdge(0, 3, 1)
    g.addEdge(1, 2, 4)
    g.addEdge(1, 3, 3)
    g.addEdge(1, 4, 5)
    g.addEdge(2, 4, 6)
    g.addEdge(3, 4, 7)

    println("Prim's Minimal Spanning Tree:")
    g.primMST()
}