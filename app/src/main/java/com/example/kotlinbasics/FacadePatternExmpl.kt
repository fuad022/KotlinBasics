package com.example.kotlinbasics

fun main() {
    // Использование фасада для взаимодействия с системой
    val carFacade = CarFacade()
    carFacade.startCar()
}

// Subsystem 1
class Engines {
    fun start() {
        println("Engine started")
    }
}

// Subsystem 2
class AirConditioner {
    fun turnOn() {
        println("Air conditioner turned on")
    }
}

// Subsystem 3
class GPS {
    fun navigate() {
        println("Navigating using GPS")
    }
}

// Фасад, предоставляющий упрощенный интерфейс для клиентов
class CarFacade {
    private val engine: Engines = Engines()
    private val airConditioner: AirConditioner = AirConditioner()
    private val gps: GPS = GPS()

    // Методы фасада, скрывающие сложность взаимодействия с подсистемой
    fun startCar() {
        engine.start()
        airConditioner.turnOn()
        gps.navigate()
        println("Car is ready to go")
    }
}