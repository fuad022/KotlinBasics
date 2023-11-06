package com.example.kotlinbasics

/*
Дан корень бинарного дерева. Каждая вершина хранит уникальное числовое значение, а также ссылки на своих детей.
Найти вершину, которая является наиболее близким общим предком для двух заданных вершин этого дерева.
 */
fun main() {
    val root = TreeNodeTN(3)
    root.left = TreeNodeTN(5)
    root.right = TreeNodeTN(1)
    root.left?.left = TreeNodeTN(6)
    root.left?.right = TreeNodeTN(2)
    root.right?.left = TreeNodeTN(0)
    root.right?.right = TreeNodeTN(8)
    root.left?.right?.left = TreeNodeTN(7)
    root.left?.right?.right = TreeNodeTN(4)

    val p = root.left?.left
    val q = root.left?.right?.right

    val lca = findLowestCommonAncestor(root, p!!, q!!)
    println("Lowest Common Ancestor: ${lca?.value}")
}

class TreeNodeTN(val value: Int) {
    var left: TreeNodeTN? = null
    var right: TreeNodeTN? = null
}

fun findLowestCommonAncestor(root: TreeNodeTN?, p: TreeNodeTN, q: TreeNodeTN): TreeNodeTN? {
    if (root == null) {
        return null
    }

    if (root == p || root == q) {
        return root
    }

    val leftLCA = findLowestCommonAncestor(root.left, p, q)
    val rightLCA = findLowestCommonAncestor(root.right, p, q)

    if (leftLCA != null && rightLCA != null) {
        return root
    }

    return leftLCA ?: rightLCA
}