package com.example.kotlinbasics

import java.util.LinkedList

fun main() {
    val linkedList = LinkedList<Int>()
//    planets.addAll(listOf("Venus", "Venus", "Venus"))
//    planets.addFirst("Venus")
//    println("planets = $planets")

    //Adding elements
    linkedList.add(3)
    linkedList.addFirst(1)
    linkedList.addLast(5)
    linkedList.offer(4)
    print(linkedList)
    println()

    //Accessing elements
    println(linkedList.peekFirst() ?: 0)
    println(linkedList.peekLast() ?: 0)

    //Removing elements
    linkedList.removeFirst()
    linkedList.removeLast()
    linkedList.remove()

    linkedList.pollFirst()
    linkedList.pollLast()
    linkedList.poll()

    for (number in linkedList) {
        print("$number ")
    }
}