package com.example.kotlinbasics

fun main() {
    val tree = BinaryTreeClass()

    // Insert values into the binary tree
    tree.insert(5)
    tree.insert(3)
    tree.insert(8)
    tree.insert(1)
    tree.insert(4)

    // Perform an inorder traversal to print the values in sorted order
    tree.inorderTraversal(tree.root)
}

class TreeNodeClass(val value: Int) {
    var left: TreeNodeClass? = null
    var right: TreeNodeClass? = null
}

class BinaryTreeClass {
    var root: TreeNodeClass? = null

    // Insert a value into the binary tree
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    // Helper function to recursively insert a value into the binary tree
    private fun insertRec(root: TreeNodeClass?, value: Int): TreeNodeClass {
        if (root == null) {
            return TreeNodeClass(value)
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value)
        } else if (value > root.value) {
            root.right = insertRec(root.right, value)
        }

        return root
    }

    // Inorder traversal to print the elements in sorted order
    fun inorderTraversal(node: TreeNodeClass?) {
        if (node != null) {
            inorderTraversal(node.left)
            println(node.value)
            inorderTraversal(node.right)
        }
    }
}