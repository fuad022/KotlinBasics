package com.example.kotlinbasics

import java.util.*

fun main() {
    val list1 = ListNodeKSNMSL(1)
    list1.next = ListNodeKSNMSL(4)
    list1.next?.next = ListNodeKSNMSL(5)

    val list2 = ListNodeKSNMSL(1)
    list2.next = ListNodeKSNMSL(3)
    list2.next?.next = ListNodeKSNMSL(4)

    val list3 = ListNodeKSNMSL(2)
    list3.next = ListNodeKSNMSL(6)

    val lists = arrayOf(list1, list2, list3)
    val k = 3

    val result = kthSmallest(lists, k)
    println("The $k-th smallest element is: $result")
}

class ListNodeKSNMSL(var `val`: Int) {
    var next: ListNodeKSNMSL? = null
}

fun kthSmallest(lists: Array<ListNodeKSNMSL>, k: Int): Int {
    val minHead = PriorityQueue<ListNodeKSNMSL?> { a, b -> a!!.`val` - b!!.`val` }

    for (list in lists) {
        if (list != null) {
            minHead.offer(list)
        }
    }

    repeat(k - 1) {
        val smallest = minHead.poll()
        if (smallest?.next != null) {
            minHead.offer(smallest.next)
        }
    }

    return minHead.poll()!!.`val`
}