package com.example.kotlinbasics

fun main() {
    val root = TreeNodeCPFS(10)
    root.left = TreeNodeCPFS(5)
    root.right = TreeNodeCPFS(-3)
    root.left!!.left = TreeNodeCPFS(3)
    root.left!!.right = TreeNodeCPFS(2)
    root.right!!.right = TreeNodeCPFS(11)
    root.left!!.left!!.left = TreeNodeCPFS(3)
    root.left!!.left!!.right = TreeNodeCPFS(-2)
    root.left!!.right!!.right = TreeNodeCPFS(1)

    val sum = 0
    val result = countPaths(root, sum)

    println("Number of paths with sum $sum: $result")
}

class TreeNodeCPFS(var `val`: Int) {
    var left: TreeNodeCPFS? = null
    var right: TreeNodeCPFS? = null
}

fun countPaths(root: TreeNodeCPFS?, sum: Int): Int {
    if (root == null) {
        return 0
    }

    // Count paths starting from the current node
    val pathsFromCurrentNode = countPathsFromNode(root, sum)

    // Recursively count paths in the left and right subtrees
    val pathFromLeftSubtree = countPaths(root.left, sum)
    val pathsFromRightSubtree = countPaths(root.right, sum)

    return pathsFromCurrentNode + pathFromLeftSubtree + pathsFromRightSubtree
}

fun countPathsFromNode(node: TreeNodeCPFS?, sum: Int): Int {
    if (node == null) {
        return 0
    }

    // Check if the current node contributes to the sum
    val pathsFromCurrentNode = if (node.`val` == sum) 1 else 0

    // Recursively count paths in the left and right subtrees
    val pathsFromLeftSubtree = countPathsFromNode(node.left, sum - node.`val`)
    val pathsFromRightSubtree = countPathsFromNode(node.right, sum - node.`val`)

    return pathsFromCurrentNode + pathsFromLeftSubtree + pathsFromRightSubtree
}