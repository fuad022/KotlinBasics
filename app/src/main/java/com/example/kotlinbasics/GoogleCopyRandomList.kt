package com.example.kotlinbasics

fun main() {
    val node1 = RandomListNode(1)
    val node2 = RandomListNode(2)
    val node3 = RandomListNode(3)

    node1.next = node2
    node2.next = node3

    node1.random = node3
    node2.random = node1
    node3.random = node2

    val copiedList = copyRandomList(node1)

    printList("Original List:", node1)
    printList("Copied List:", copiedList)
}

class RandomListNode(val value: Int) {
    var next: RandomListNode? = null
    var random: RandomListNode? = null
}

fun copyRandomList(head: RandomListNode?): RandomListNode? {
    if (head == null) return null

    var current = head
    while (current != null) {
        val copy = RandomListNode(current.value)
        copy.next = current.next
        current.next = copy
        current = copy.next
    }

    current = head
    while (current != null) {
        val copy = current.next
        copy?.random = current.random?.next
        current = copy?.next
    }

    val newHead = head.next
    var originalCurrent = head
    var copyCurrent = newHead

    while (originalCurrent != null) {
        originalCurrent.next = copyCurrent?.next
        originalCurrent = originalCurrent.next
        copyCurrent = copyCurrent?.next
    }

    return newHead
}

fun printList(label: String, head: RandomListNode?) {
    var current = head
    print("$label")
    while (current != null) {
        print("${current.value}(${current.random?.value ?: "null"}) -> ")
        current = current.next
    }
    println("null")
}