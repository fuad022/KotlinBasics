package com.example.kotlinbasics

fun main() {
    val bst = BinarySearchTree()

    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(40)
    bst.insert(70)
    bst.insert(60)
    bst.insert(80)

    println("Inorder traversal of the binary search tree:")
    bst.inorderTraversal()

    val keyToSearch = 40
    if (bst.search(keyToSearch)) {
        println("$keyToSearch found in the tree.")
    } else {
        println("$keyToSearch not found in the tree.")
    }
}

class NodeClass(var key: Int) {
    var left: NodeClass? = null
    var right: NodeClass? = null
}

class BinarySearchTree {
    var root: NodeClass? = null

    fun insert(key: Int) {
        root = insertRec(root, key)
    }

    private fun insertRec(root: NodeClass?, key: Int): NodeClass {
        if (root == null) {
            return NodeClass(key)
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key)
        } else if (key > root.key) {
            root.right = insertRec(root.right, key)
        }

        return root
    }

    fun search(key: Int): Boolean {
        return searchRec(root, key)
    }

    private fun searchRec(root: NodeClass?, key: Int): Boolean {
        if (root == null) {
            return false
        }

        if (key == root.key) {
            return true
        }

        return if (key < root.key) {
            searchRec(root.left, key)
        } else {
            searchRec(root.right, key)
        }
    }

    fun inorderTraversal() {
        inorderTraversalRec(root)
    }

    private fun inorderTraversalRec(root: NodeClass?) {
        if (root != null) {
            inorderTraversalRec(root.left)
            println(root.key)
            inorderTraversalRec(root.right)
        }
    }
}