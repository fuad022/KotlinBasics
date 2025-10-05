package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val medianFinder = MedianFinder()
    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian()) // Output: 1.5
    medianFinder.addNum(3)
    println(medianFinder.findMedian()) // Output: 2.0
}

class MedianFinder() {
    // Max heap for the left half of the numbers
    private val maxHeap = PriorityQueue<Int> { a, b -> b - a }

    // Min heap for the right half of the numbers
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        // Add the number to the max heap if it's empty or less than or equal to the maximum in the max heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        // Balance the heaps
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.offer(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            maxHeap.peek().toDouble()
        }
    }
}