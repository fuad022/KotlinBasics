package com.example.kotlinbasics

fun main() {
    val intervals = listOf(
        IntervalMOII(1, 3),
        IntervalMOII(2, 3),
        IntervalMOII(8, 10),
        IntervalMOII(15, 18)
    )

    val mergedIntervals = mergeOverlappingIntervals(intervals)

    println("Merged Intervals: $mergedIntervals")
}

data class IntervalMOII(val start: Int, val end: Int)

fun mergeOverlappingIntervals(intervals: List<IntervalMOII>): List<IntervalMOII> {
    if (intervals.isEmpty()) {
        return emptyList()
    }

    val sortedIntervals = intervals.sortedBy { it.start }
    val result = mutableListOf<IntervalMOII>()

    var currentInterval = sortedIntervals[0]

    for (i in 1 until sortedIntervals.size) {
        val nextInterval = sortedIntervals[i]

        if (currentInterval.end >= nextInterval.start) {
            // Merge overlapping intervals
            currentInterval =
                IntervalMOII(currentInterval.start, maxOf(currentInterval.end, nextInterval.end))
        } else {
            // Add non-overlapping interval to the result
            result.add(currentInterval)
            currentInterval = nextInterval
        }
    }

    result.add(currentInterval)

    return result
}