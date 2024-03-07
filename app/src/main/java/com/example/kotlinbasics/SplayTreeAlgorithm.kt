package com.example.kotlinbasics

class SplayTree<T : Comparable<T>> {
    data class Node<T>(
        var key: T,
        var parent: Node<T>? = null,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )

    private var root: Node<T>? = null

    // Rotate a node to the left
    private fun rotateLeft(x: Node<T>) {
        val y = x.right
        y?.let {
            x.right = y.left
            y.left?.parent = x
            y.parent = x.parent
        }
        if (x.parent == null) {
            root = y
        } else if (x == x.parent?.left) {
            x.parent?.left = y
        } else {
            x.parent?.right = y
        }
        y?.left = x
        x.parent = y
    }

    // Rotate a node to the right
    private fun rotateRight(x: Node<T>) {
        val y = x.left
        y?.let {
            x.left = y.right
            y.right?.parent = x
            y.parent = x.parent
        }
        if (x.parent == null) {
            root = y
        } else if (x == x.parent?.right) {
            x.parent?.right = y
        } else {
            x.parent?.left = y
        }
        y?.right = x
        x.parent = y
    }

    // Splay operation
    private fun splay(x: Node<T>) {
        while (x.parent != null) {
            if (x.parent?.parent == null) {
                if (x == x.parent?.left) {
                    rotateRight(x.parent!!)
                } else {
                    rotateLeft(x.parent!!)
                }
            } else if (x == x.parent?.left && x.parent == x.parent?.parent?.left) {
                rotateRight(x.parent!!.parent!!)
                rotateRight(x.parent!!)
            } else if (x == x.parent?.right && x.parent == x.parent?.parent?.right) {
                rotateLeft(x.parent!!.parent!!)
                rotateLeft(x.parent!!)
            } else if (x == x.parent?.left && x.parent == x.parent?.parent?.right) {
                rotateRight(x.parent!!)
                rotateLeft(x.parent!!)
            } else {
                rotateLeft(x.parent!!)
                rotateRight(x.parent!!)
            }
        }
    }

    // Insert a key into the tree
    fun insert(key: T) {
        var current = root
        var parent: Node<T>? = null
        while (current != null) {
            parent = current
            current = if (key < current.key) current.left else current.right
        }
        val newNode = Node(key, parent)
        if (parent == null) {
            root = newNode
        } else if (key < parent.key) {
            parent.left = newNode
        } else {
            parent.right = newNode
        }
        splay(newNode)
    }

    // Search for a key in the tree
    fun search(key: T): Boolean {
        var current = root
        while (current != null) {
            if (key == current.key) {
                splay(current)
                return true
            } else if (key < current.key) {
                current = current.left
            } else {
                current = current.right
            }
        }
        return false
    }

    // In-order traversal of the tree
    private fun inorderTraversal(node: Node<T>?) {
        if (node != null) {
            inorderTraversal(node.left)
            println(node.key)
            inorderTraversal(node.right)
        }
    }

    fun printTree() {
        inorderTraversal(root)
    }
}

fun main() {
    val tree = SplayTree<Int>()
    tree.insert(10)
    tree.insert(5)
    tree.insert(15)
    tree.insert(3)
    tree.insert(7)
    tree.insert(12)
    tree.insert(17)

    println("Tree after insertions:")
    tree.printTree()

    println("Search for 12: ${tree.search(12)}")
    println("Tree after searching for 12:")
    tree.printTree()

    println("Search for 20: ${tree.search(20)}")
    println("Tree after searching for 20:")
    tree.printTree()
}
