package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val k = 1
    val kthLargestElementFinder = KthLargestElementInStream(k)

    val numbers = listOf(4, 2, 6, 1, 5, 3)

    for (num in numbers) {
        kthLargestElementFinder.addNumber(num)
        val kthLargest = kthLargestElementFinder.findKthLargest()
        println("Current Kth Largest Element: $kthLargest")
    }
}

class KthLargestElementInStream(private val k: Int) {
    private val minHeap = PriorityQueue<Int>()

    fun addNumber(num: Int) {
        minHeap.offer(num)

        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

    fun findKthLargest(): Int? {
        if (minHeap.size < k) {
            throw NoSuchElementException("Not enough elements in the stream to find the $k largest element.")
        }
        return minHeap.peek()
    }
}