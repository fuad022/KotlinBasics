package com.example.kotlinbasics

fun main() {
    val tasks = listOf(
        TaskCanSchedule("Task A", 3),
        TaskCanSchedule("Task B", 2),
        TaskCanSchedule("Task C", 4),
        // Add more tasks as needed
    )

    if (canSchedule(tasks)) {
        println("All tasks can be scheduled without overlapping.")
    } else {
        println("Tasks cannot be scheduled without overlapping.")
    }
}

const val MAX_SCHEDULE_DURATION = 10

data class TaskCanSchedule(val name: String, val duration: Int)

fun canSchedule(tasks: List<TaskCanSchedule>): Boolean {
    // Sort tasks by duration in descending order
    val sortedTasks = tasks.sortedByDescending { it.duration }

    // Initialize the schedule
    val schedule = mutableListOf<TaskCanSchedule>()

    // Try to schedule each task
    for (task in sortedTasks) {
        if (canAddTaskToSchedule(task, schedule)) {
            schedule.add(task)
        } else {
            // If a task cannot be scheduled, return false
            return false
        }
    }

    // All tasks can be scheduled without overlapping
    return true
}

fun canAddTaskToSchedule(task: TaskCanSchedule, schedule: List<TaskCanSchedule>): Boolean {
    // Check if the task can be added to the schedule without overlapping with existing tasks
    val taskEndTime = schedule.sumBy { it.duration }
    return taskEndTime + task.duration <= MAX_SCHEDULE_DURATION
}