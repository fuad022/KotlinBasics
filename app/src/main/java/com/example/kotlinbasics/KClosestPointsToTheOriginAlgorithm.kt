package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val points = arrayOf(Point(1, 3), Point(-2, 2), Point(5, 8), Point(0, 1))
    val k = 2

    val closestPoints = kClosest(points, k)

    println("The $k closest points to the origin are:")
    closestPoints.forEach { println("(${it.x}, ${it.y})") }
}

data class Point(val x: Int, val y: Int)

fun kClosest(points: Array<Point>, k: Int): Array<Point> {
    val priorityQueue = PriorityQueue<Point> { p1, p2 ->
        (p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y)
    }

    for (point in points) {
        priorityQueue.offer(point)
        if (priorityQueue.size > k) {
            priorityQueue.poll()
        }
    }

    return priorityQueue.toTypedArray()
}