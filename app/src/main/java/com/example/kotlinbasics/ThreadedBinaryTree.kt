package com.example.kotlinbasics

class ThreadedBinaryTree {
    data class Node(
        var data: Int,
        var left: Node? = null,
        var right: Node? = null,
        var isThreadedRight: Boolean = false,
        var isThreadedLeft: Boolean = false
    )

    private var root: Node? = null

    fun insert(data: Int) {
        root = insertRec(root, data)
    }

    private fun insertRec(root: Node?, data: Int): Node {
        if (root == null) {
            return Node(data)
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data)
            if (root.left!!.isThreadedRight) {
                root.left!!.right = root
                root.left!!.isThreadedRight = false
            }
        } else if (data > root.data) {
            if (root.isThreadedRight) {
                val newNode = Node(data)
                newNode.right = root.right
                newNode.isThreadedRight = true
                root.right = newNode
                root.isThreadedRight = false
            } else {
                root.right = insertRec(root.right, data)
            }
        }

        return root
    }

    fun inorderTraversal() {
        var current = leftMost(root)
        while (current != null) {
            println(current.data)
            current = if (current.isThreadedRight) {
                current.right
            } else {
                leftMost(current.right)
            }
        }
    }

    private fun leftMost(node: Node?): Node? {
        var current = node
        while (current != null && current.left != null) {
            current = current.left
        }
        return current
    }
}

fun main() {
    val tree = ThreadedBinaryTree()
    tree.insert(4)
    tree.insert(2)
    tree.insert(6)
    tree.insert(1)
    tree.insert(3)
    tree.insert(5)
    tree.insert(7)

    println("Inorder traversal:")
    tree.inorderTraversal()
}
