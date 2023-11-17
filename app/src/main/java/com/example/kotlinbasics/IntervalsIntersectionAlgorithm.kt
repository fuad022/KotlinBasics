package com.example.kotlinbasics

fun main() {
    val interval1 = Interval(1, 5)
    val interval2 = Interval(3, 7)

    val intersection = findIntervalIntersection(interval1, interval2)

    if (intersection != null) {
        println("Intervals intersect: ${intersection.start} to ${intersection.end}")
    } else {
        println("Intervals do not intersect")
    }
}

data class Interval(val start: Int, val end: Int)

fun findIntervalIntersection(interval1: Interval, interval2: Interval): Interval? {
    val maxStart = maxOf(interval1.start, interval2.start)
    val minEnd = minOf(interval1.end, interval2.end)

    if (maxStart <= minEnd) {
        return Interval(maxStart, minEnd)
    }

    return null
}