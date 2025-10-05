package com.example.kotlinbasics

fun main() {
    val linkedList = LinkedListDeleteNode()

    linkedList.head = NodeDeleteNode(1)
    linkedList.head?.next = NodeDeleteNode(2)
    linkedList.head?.next?.next = NodeDeleteNode(3)
    linkedList.head?.next?.next?.next = NodeDeleteNode(4)

    println("Original Linked List:")
    linkedList.displayListDeleteNode()

    val keyToDelete = 3
    linkedList.deleteNode(keyToDelete)

    println("Linked List after deleting node with key $keyToDelete:")
    linkedList.displayListDeleteNode()
}

class NodeDeleteNode(var data: Int) {
    var next: NodeDeleteNode? = null
}

class LinkedListDeleteNode {
    var head: NodeDeleteNode? = null

    fun deleteNode(key: Int) {
        var current = head
        var prev: NodeDeleteNode? = null

        if (current != null && current.data == key) {
            head = current.next
            return
        }

        while (current != null && current.data != key) {
            prev = current
            current = current.next
        }

        if (current == null) {
            return
        }

        prev?.next = current.next
    }

    fun displayListDeleteNode() {
        var current = head
        while (current != null) {
            print("${current.data}")
            current = current.next
        }
        println()
    }
}
