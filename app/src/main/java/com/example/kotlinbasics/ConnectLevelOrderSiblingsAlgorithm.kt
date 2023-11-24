package com.example.kotlinbasics

import java.util.*
import java.util.LinkedList

fun main() {
    // Create a sample binary tree
    val root = TreeNodeCLOS(1)
    root.left = TreeNodeCLOS(2)
    root.right = TreeNodeCLOS(3)
    root.left?.left = TreeNodeCLOS(4)
    root.left?.right = TreeNodeCLOS(5)
    root.right?.right = TreeNodeCLOS(7)

    // Connect level-order siblings
    connectLevelOrderSiblings(root)

    // Print the connected siblings at each level
    printLevelOrderSiblings(root)
}

// Define a simple binary tree node class
data class TreeNodeCLOS(
    val value: Int,
    var left: TreeNodeCLOS? = null,
    var right: TreeNodeCLOS? = null,
    var nextSibling: TreeNodeCLOS? = null
)

fun connectLevelOrderSiblings(root: TreeNodeCLOS?) {
    if (root == null) {
        return
    }

    // Use a queue for level-order traversal
    val queue: Queue<TreeNodeCLOS> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var prevNode: TreeNodeCLOS? = null

        // Process nodes at the current level
        for (i in 0 until levelSize) {
            val currentNode = queue.poll()

            // Connect the node to its previous sibling
            if (prevNode != null) {
                prevNode.nextSibling = currentNode
            }

            // Update the previous node for the next iteration
            prevNode = currentNode

            // Enqueue the children for the next level
            currentNode.left?.let { queue.offer(it) }
            currentNode.right?.let { queue.offer(it) }
        }
    }
}

// Helper function to print level-order siblings
fun printLevelOrderSiblings(root: TreeNodeCLOS?) {
    var currentLevel = root
    while (currentLevel != null) {
        var currentNode = currentLevel
        while (currentNode != null) {
            print("${currentNode.value}")
            currentNode = currentNode.nextSibling
        }
        println()
        currentLevel = if (currentLevel.left != null) currentLevel.left else currentLevel.right
    }
}