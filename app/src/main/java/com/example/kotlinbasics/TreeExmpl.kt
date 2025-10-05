package com.example.kotlinbasics

fun main() {
    val milkTree = TreeNode("Milk")
    val beveragesNode = TreeNode("Beverages")
    val curdNode = TreeNode("Curd")
    milkTree.addChild(beveragesNode)
    milkTree.addChild(curdNode)

    val teaNode = TreeNode("tea")
    val coffeeNode = TreeNode("coffee")
    val milkShakeNode = TreeNode("Milk Shake")
    beveragesNode.addChild(teaNode)
    beveragesNode.addChild(coffeeNode)
    beveragesNode.addChild(milkShakeNode)

    val gingerTeaNode = TreeNode("ginger tea")
    val normalTeaNode = TreeNode("normal tea")
    teaNode.addChild(gingerTeaNode)
    teaNode.addChild(normalTeaNode)

    val yogurtNode = TreeNode("yogurt")
    val lassiNode = TreeNode("lassi")
    curdNode.addChild(yogurtNode)
    curdNode.addChild(lassiNode)

    println(milkTree)
}

class TreeNode<T>(value: T) {
    var value: T = value
    private var parent: TreeNode<T>? = null

    private var children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node: TreeNode<T>) {
        children.add(node)
        node.parent = this
    }

    override fun toString(): String {
        var s = "$value"
        if (children.isNotEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }
}