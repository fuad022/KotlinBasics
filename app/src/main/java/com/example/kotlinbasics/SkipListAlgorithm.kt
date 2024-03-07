package com.example.kotlinbasics

import java.util.Random

fun main() {
    val skipList = SkipList<Int>()
    skipList.add(3)
    skipList.add(6)
    skipList.add(9)
    println(skipList.contains(6)) // Output: true
    println(skipList.contains(8)) // Output: false
}

class SkipListNode<T : Comparable<T>>(
    val value: T,
    val level: Int,
    val next: MutableList<SkipListNode<T>?> = MutableList(level + 1) { null }
)

class SkipList<T : Comparable<T>> {
    private val head = SkipListNode<T>(value = (Int.MIN_VALUE as T), level = MAX_LEVEL)
    private val tail = SkipListNode<T>(value = (Int.MAX_VALUE as T), level = MAX_LEVEL)
    private var maxLevel = 0
    private val random = Random(System.currentTimeMillis())

    init {
        repeat(MAX_LEVEL + 1) { head.next.add(tail) }
    }

    fun add(value: T) {
        val update = MutableList(MAX_LEVEL + 1) { head }
        var node = head

        for (i in maxLevel downTo 0) {
            while (node.next[i]?.value != null && node.next[i]?.value!! < value) {
                node = node.next[i]!!
            }
            update[i] = node
        }

        val newNodeLevel = randomLevel()
        val newNode = SkipListNode(value, newNodeLevel)

        for (i in 0..newNodeLevel) {
            newNode.next[i] = update[i].next[i]
            update[i].next[i] = newNode
        }

        if (newNodeLevel > maxLevel) {
            maxLevel = newNodeLevel
        }
    }

    fun contains(value: T): Boolean {
        var current = head
        for (i in maxLevel downTo 0) {
            while (current.next[i]?.value != null && current.next[i]?.value!! < value) {
                current = current.next[i]!!
            }
        }
        current = current.next[0] ?: return false
        return current.value == value
    }

    private fun randomLevel(): Int {
        var level = 0
        while (random.nextDouble() < PROBABILITY && level < MAX_LEVEL) {
            level++
        }
        return level
    }

    companion object {
        private const val MAX_LEVEL = 16
        private const val PROBABILITY = 0.5
    }
}