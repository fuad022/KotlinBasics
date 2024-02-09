package com.example.kotlinbasics

data class JobSP(val id: Int, val deadline: Int, val profit: Int)

fun scheduleJobs(jobs: List<JobSP>): List<JobSP> {
    val sortedJobs = jobs.sortedByDescending { it.profit }

    val maxDeadline = sortedJobs.maxByOrNull { it.deadline }?.deadline ?: 0
    val schedule = mutableListOf<JobSP?>()

    repeat(maxDeadline) { schedule.add(null) }

    for (job in sortedJobs) {
        var slot = job.deadline - 1
        while (slot >= 0 && schedule[slot] != null) {
            slot--
        }

        if (slot >= 0) {
            schedule[slot] = job
        }
    }

    return schedule.filterNotNull()
}

fun main() {
    val jobs = listOf(
        JobSP(1, 2, 100),
        JobSP(2, 1, 50),
        JobSP(3, 2, 10),
        JobSP(4, 1, 20),
        JobSP(5, 3, 30)
    )

    val scheduledJobs = scheduleJobs(jobs)
    println("Scheduled Jobs:")
    scheduledJobs.forEach { println("Job ${it.id} with profit ${it.profit} and deadline ${it.deadline}") }
}