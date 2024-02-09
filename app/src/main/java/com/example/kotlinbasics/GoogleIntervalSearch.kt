package com.example.kotlinbasics

fun main() {
    val intervals = listOf(
        IntervalIS(1, 5),
        IntervalIS(6, 10),
        IntervalIS(11, 15),
        IntervalIS(16, 20)
    )

    val point = 12
    val index = intervalSearch(intervals, point)

    if (index != -1) {
        println("Point $point is within interval at index $index")
    } else {
        println("Point $point is not within any interval")
    }
}

data class IntervalIS(val start: Int, val end: Int)

fun intervalSearch(intervals: List<IntervalIS>, point: Int): Int {
    var low = 0
    var high = intervals.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        val interval = intervals[mid]

        if (point >= interval.start && point <= interval.end) {
            return mid // Point lies within the interval
        } else if (point < interval.start) {
            high = mid - 1 // Point lies to the left of the interval
        } else {
            low = mid + 1 // Point lies to the right of the interval
        }
    }

    return -1 // Point is not within any interval
}