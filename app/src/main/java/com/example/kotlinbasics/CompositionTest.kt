package com.example.kotlinbasics

fun main() {
    // Создаем объекты
    val engine = Engine()
    val car = Car(engine)

    // Запускаем автомобиль
    car.startCar()
}

// Пример композиции с использованием классов
class Engine {
    fun start() {
        println("Engine started")
    }
}

class Car(private val engine: Engine) {
    fun startCar() {
        engine.start()
        println("Car started")
    }
}
