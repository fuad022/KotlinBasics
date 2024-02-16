package com.example.kotlinbasics

fun main() {
    val uf = UnionFind(5)
    uf.union(0, 1)
    uf.union(1, 2)
    println(uf.connected(0, 2)) // true
    println(uf.connected(0, 3)) // false
}

class UnionFind(n: Int) {
    private val parent = IntArray(n)
    private val rank = IntArray(n)

    init {
        for (i in 0 until n) {
            parent[i] = i
            rank[i] = 0
        }
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}