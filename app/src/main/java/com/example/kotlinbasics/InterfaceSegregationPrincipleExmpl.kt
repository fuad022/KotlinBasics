package com.example.kotlinbasics

fun main() {
    val human = HumanISP()
    val robot = RobotISP()

    val workers: List<WorkerISP> = listOf(human, robot)

    for (worker in workers) {
        worker.work()
    }

    val eaters: List<EaterISP> = listOf(human)

    for (eater in eaters) {
        eater.eat()
    }
}

interface WorkerISP {
    fun work()
}

interface EaterISP {
    fun eat()
}

class HumanISP : WorkerISP, EaterISP {
    override fun work() {
        // Реализация работы человека
        println("Человек работает")
    }

    override fun eat() {
        // Реализация приема пищи человека
        println("Человек ест")
    }
}

class RobotISP : WorkerISP {
    override fun work() {
        // Реализация работы робота
        println("Робот работает")
    }
}