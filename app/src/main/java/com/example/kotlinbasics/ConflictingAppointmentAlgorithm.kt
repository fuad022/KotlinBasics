package com.example.kotlinbasics

fun main() {
    val appointment1 =
        Appointment(startTime = 1636890000000, endTime = 1636893600000, title = "Meeting 1")
    val appointment2 =
        Appointment(startTime = 1636891800000, endTime = 1636895400000, title = "Meeting 2")

    val conflict = isConflict(appointment1, appointment2)

    if (conflict) {
        println("There is conflict between ${appointment1.title} and ${appointment2.title}")
    } else {
        println("No conflict between ${appointment1.title} and ${appointment2.title}")
    }
}

data class Appointment(val startTime: Long, val endTime: Long, val title: String)

fun isConflict(appointment1: Appointment, appointment2: Appointment): Boolean {
    return !(appointment1.endTime <= appointment2.startTime || appointment1.startTime >= appointment2.endTime)
}