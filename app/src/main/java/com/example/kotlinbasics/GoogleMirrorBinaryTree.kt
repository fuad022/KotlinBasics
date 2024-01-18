package com.example.kotlinbasics

fun main() {
    val root = TreeNodeMirrorBinaryTree(1)
    root.left = TreeNodeMirrorBinaryTree(2)
    root.right = TreeNodeMirrorBinaryTree(3)
    root.left?.left = TreeNodeMirrorBinaryTree(4)
    root.left?.right = TreeNodeMirrorBinaryTree(5)
    root.left?.left = TreeNodeMirrorBinaryTree(6)
    root.left?.right = TreeNodeMirrorBinaryTree(7)

    println("Original Binary Tree:")
    printTree(root)

    mirrorBinaryTree(root)

    println("\nMirrored Binary Tree:")
    printTree(root)
}

class TreeNodeMirrorBinaryTree(var value: Int) {
    var left: TreeNodeMirrorBinaryTree? = null
    var right: TreeNodeMirrorBinaryTree? = null
}

fun mirrorBinaryTree(root: TreeNodeMirrorBinaryTree?) {
    if (root == null) {
        return
    }

    val temp = root.left
    root.left = root.right
    root.right = temp

    mirrorBinaryTree(root.left)
    mirrorBinaryTree(root.right)
}

fun printTree(root: TreeNodeMirrorBinaryTree?) {
    if (root == null) {
        return
    }

    printTree(root.left)
    print("${root.value}")
    printTree(root.right)
}