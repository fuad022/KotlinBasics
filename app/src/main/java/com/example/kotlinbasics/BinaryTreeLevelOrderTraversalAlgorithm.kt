package com.example.kotlinbasics

import java.util.LinkedList
import java.util.Queue

fun main() {
    // Example binary tree:
    //     3
    //    / \
    //   9  20
    //      / \
    //     15  7

    val root = TreeNodeBTLOT(3)
    root.left = TreeNodeBTLOT(9)
    root.right = TreeNodeBTLOT(20)
    root.right?.left = TreeNodeBTLOT(15)
    root.right?.right = TreeNodeBTLOT(7)

    val traversalResult = levelOrderTraversal(root)
    println(traversalResult) // Output: [[3], [9, 20], [15, 7]]
}

// Definition for a binary tree node.
class TreeNodeBTLOT(var `val`: Int) {
    var left: TreeNodeBTLOT? = null
    var right: TreeNodeBTLOT? = null
}

fun levelOrderTraversal(root: TreeNodeBTLOT?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (root == null) {
        return result
    }

    val queue: Queue<TreeNodeBTLOT> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()
            currentLevel.add(currentNode.`val`)

            currentNode.left?.let { queue.offer(it) }
            currentNode.right?.let { queue.offer(it) }
        }

        result.add(currentLevel)
    }

    return result
}