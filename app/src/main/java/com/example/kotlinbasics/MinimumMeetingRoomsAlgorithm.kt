package com.example.kotlinbasics

import java.util.PriorityQueue

fun main() {
    val meetings = listOf(Meeting(0, 30), Meeting(5, 10), Meeting(15, 20))
    val result = minMeetingRooms(meetings)
    println("Minimum meeting rooms required: $result")
}

data class Meeting(val start: Int, val end: Int)

fun minMeetingRooms(meeting: List<Meeting>): Int {
    if (meeting.isEmpty()) {
        return 0
    }

    // Sort meetings by start time
    val sortedMeetings = meeting.sortedBy { it.start }

    // Use a min heap to track end times of ongoing meetings
    val minHeap = PriorityQueue<Int>()

    // Add the end time of the first meeting
    minHeap.offer(sortedMeetings[0].end)

    // Iterate through th rest of the meetings
    for (i in 1 until sortedMeetings.size) {
        val currentMeeting = sortedMeetings[i]

        // If the current meeting can be accommodated in an existing room (its start time is after the earliest end time),
        // update the end time of that room
        if (currentMeeting.start >= minHeap.peek()) {
            minHeap.poll()
        }

        // Add the end time of the current meeting to the heap
        minHeap.offer(currentMeeting.end)
    }

    // The size of the heap represents the minimum number of meeting rooms required
    return minHeap.size
}