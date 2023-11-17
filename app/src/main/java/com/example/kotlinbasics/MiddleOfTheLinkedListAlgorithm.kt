package com.example.kotlinbasics

fun main() {
    val linkedList = LinkedList()
    linkedList.insertMLL(1)
    linkedList.insertMLL(2)
    linkedList.insertMLL(3)
    linkedList.insertMLL(4)
    linkedList.insertMLL(5)

    val middleNode = linkedList.findMiddle()
    if (middleNode != null) {
        println("The middle of the linked list is: ${middleNode.data}")
    } else {
        println("The list is empty.")
    }
}

class NodeMLL(var data: Int) {
    var next: NodeMLL? = null
}

class LinkedList {
    var head: NodeMLL? = null

    fun insertMLL(data: Int) {
        val newNode = NodeMLL(data)
        if (head == null) {
            head = newNode
        } else {
            var temp = head
            while (temp?.next != null) {
                temp = temp.next
            }
            temp?.next = newNode
        }
    }

    fun findMiddle(): NodeMLL? {
        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}