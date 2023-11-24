package com.example.kotlinbasics

fun main() {
    val root = TreeNodePWGS(0)
    root.left = TreeNodePWGS(1)
    root.right = TreeNodePWGS(0)
    root.left!!.left = TreeNodePWGS(0)
    root.left!!.right = TreeNodePWGS(1)
    root.right!!.left = TreeNodePWGS(0)
    root.right!!.right = TreeNodePWGS(0)

    val sequence = intArrayOf(0, 1, 0, 1)

    val result = isValidSequence(root, sequence)

    if (result) {
        println("The sequence is a valid path.")
    } else {
        println("The sequence is not a valid path.")
    }
}

class TreeNodePWGS(val value: Int, var left: TreeNodePWGS? = null, var right: TreeNodePWGS? = null)

fun isValidSequence(root: TreeNodePWGS?, arr: IntArray): Boolean {
    return isValidSequenceHelper(root, arr, 0)
}

fun isValidSequenceHelper(node: TreeNodePWGS?, arr: IntArray, index: Int): Boolean {
    if (node == null || index >= arr.size || node.value != arr[index]) {
        return false
    }

    if (node.left == null && node.right == null) {
        // Leaf node, check if we have reached the end of the array
        return index == arr.size - 1
    }

    // Recursively check the left and right subtrees
    val leftResult = isValidSequenceHelper(node.left, arr, index + 1)
    val rightResult = isValidSequenceHelper(node.right, arr, index + 1)

    return leftResult || rightResult
}