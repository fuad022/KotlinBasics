package com.example.kotlinbasics

// Example usage
fun main() {
    val head = ListNodeRLL(1)
    head.next = ListNodeRLL(2)
    head.next?.next = ListNodeRLL(3)
    head.next?.next?.next = ListNodeRLL(4)
    head.next?.next?.next?.next = ListNodeRLL(5)

    val rotatedHead = rotateLinkedList(head, 2)

    var current: ListNodeRLL? = rotatedHead
    while (current != null) {
        print("${current.value}")
        current = current.next
    }
}

class ListNodeRLL(var value: Int) {
    var next: ListNodeRLL? = null
}

fun rotateLinkedList(head: ListNodeRLL?, k: Int): ListNodeRLL? {
    if (head == null || k <= 0) {
        return head
    }

    var current: ListNodeRLL? = head
    var length = 1

    // Find the length of the linked list and the last node
    while (current?.next != null) {
        current = current.next
        length++
    }

    // Make the linked list circular
    current?.next = head

    // Calculate the effective rotation
    val effectiveRotation = k % length

    // Find the new head after rotation
    for (i in 0 until length - effectiveRotation) {
        current = current?.next
    }

    // Set the new head and break the circular link
    val newHead = current?.next
    current?.next = null

    return newHead
}