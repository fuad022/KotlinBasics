package com.example.kotlinbasics

fun main() {
    val root = TreeNodeMDOBT(1)
    root.left = TreeNodeMDOBT(2)
    root.right = TreeNodeMDOBT(3)
    root.left?.left = TreeNodeMDOBT(4)
    root.left?.right = TreeNodeMDOBT(5)

    val depth = minDepth(root)
    println("Minimum Depth of the Binary Tree: $depth")
}

class TreeNodeMDOBT(var `val`: Int) {
    var left: TreeNodeMDOBT? = null
    var right: TreeNodeMDOBT? = null
}

fun minDepth(root: TreeNodeMDOBT?): Int {
    if (root == null) {
        return 0
    }

    // If the current node is a leaf node, return 1
    if (root.left == null && root.right == null) {
        return 1
    }

    val minVal = Int.MIN_VALUE
    val maxVal = Int.MAX_VALUE
    println("$minVal \n $maxVal")

    // Calculate the minimum depth of the left and right subtrees
    val leftDepth = if (root.left != null) minDepth(root.left) else Int.MAX_VALUE
    val rightDepth = if (root.right != null) minDepth(root.right) else Int.MIN_VALUE

    return 1 + Math.min(leftDepth, rightDepth)
}