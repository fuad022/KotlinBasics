package com.example.kotlinbasics

fun main() {
    val size = 5
    val disjointSet = DisjointSet(size)

    // Пример использования:
    disjointSet.union(0, 1)
    disjointSet.union(1, 2)
    disjointSet.union(3, 4)

    println(disjointSet.isConnected(0, 2)) // false
    println(disjointSet.isConnected(1, 3)) // false

    disjointSet.union(2, 3)

    println(disjointSet.isConnected(0, 2)) // true
    println(disjointSet.isConnected(1, 3)) // true
}

class DisjointSet(size: Int) {
    private val parent: IntArray = IntArray(size)

    init {
        // Изначально каждый элемент считается отдельным множеством,
        // и его родителем является сам он.
        for (i in parent.indices) {
            parent[i] = i
        }
    }

    // Найти представителя (родителя) множества для данного элемента.
    private fun find(element: Int): Int {
        if (parent[element] == element) {
            return element
        }
        // Рекурсивно ищем представителя для родителя текущего элемента.
        parent[element] = find(parent[element])
        return parent[element]
    }

    // Объединение двух множеств по их представителям.
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        // Объединяем множества только если они не принадлежат одному и тому же множеству.
        if (rootX != rootY) {
            parent[rootX] = rootY
        }
    }

    // Проверка принадлежности двух элементов к одному множеству.
    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}