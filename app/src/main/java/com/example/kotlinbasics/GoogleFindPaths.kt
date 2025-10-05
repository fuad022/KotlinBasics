package com.example.kotlinbasics

fun main() {
    val root = TreeNodeFindPaths(
        10,
        TreeNodeFindPaths(
            5,
            TreeNodeFindPaths(3, TreeNodeFindPaths(3), TreeNodeFindPaths(-2)),
            TreeNodeFindPaths(2, null, TreeNodeFindPaths(1))
        ),
        TreeNodeFindPaths(-3, null, TreeNodeFindPaths(11))
    )

    val targetSum = 8
    val paths = findPaths(root, targetSum)

    println("Paths with sum $targetSum")
    paths.forEach { println(it) }
}

class TreeNodeFindPaths(
    val value: Int,
    var left: TreeNodeFindPaths? = null,
    var right: TreeNodeFindPaths? = null
)

fun findPaths(root: TreeNodeFindPaths?, targetSum: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val currentPath = mutableListOf<Int>()

    fun dfs(node: TreeNodeFindPaths?, currentSum: Int) {
        if (node == null) return

        currentPath.add(node.value)
        val newSum = currentSum + node.value

        if (node.left == null && node.right == null && newSum == targetSum) {
            result.add(currentPath.toList())
        }

        dfs(node.left, newSum)
        dfs(node.right, newSum)

        currentPath.removeAt(currentPath.size - 1)
    }

    dfs(root, 0)
    return result
}