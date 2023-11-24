package com.example.kotlinbasics

fun main() {
    val intervals = listOf(
        IntervalNI(1, 5),
        IntervalNI(6, 10),
        IntervalNI(12, 15)
    )

    val targetTime = 8
    val nextInterval = findNextInterval(intervals, targetTime)

    if (nextInterval != null) {
        println("Next interval: (${nextInterval.start}, ${nextInterval.end})")
    } else {
        println("No next interval found.")
    }
}

data class IntervalNI(val start: Int, val end: Int)

fun findNextInterval(intervals: List<IntervalNI>, targetTime: Int): IntervalNI? {
    val sortedIntervals = intervals.sortedBy { it.start }

    for (interval in sortedIntervals) {
        if (interval.start > targetTime) {
            return interval
        }
    }

    return null
}