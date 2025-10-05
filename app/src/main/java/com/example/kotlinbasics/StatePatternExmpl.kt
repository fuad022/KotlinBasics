package com.example.kotlinbasics

fun main() {
    // Создаем объекты для каждого состояния
    val greenState = GreenState()
    val yellowState = YellowState()
    val redState = RedState()

    // Создаем объект светофора с начальным состоянием "Зеленый"
    val trafficLight = TrafficLight(greenState)

    // Проверяем состояния
    trafficLight.requestState()

    // Меняем состояние на "Желтый" и проверяем
    trafficLight.changeState(yellowState)
    trafficLight.requestState()

    // Меняем состояние на "Красный" и проверяем
    trafficLight.changeState(redState)
    trafficLight.requestState()
}

// Интерфейс для всех состояний
interface TrafficLightState {
    fun handle()
}

// Зеленый свет
class GreenState : TrafficLightState {
    override fun handle() {
        println("Горит зеленый свет. Можно двигаться.")
    }
}

// Желтый свет
class YellowState : TrafficLightState {
    override fun handle() {
        println("Горит желтый свет. Приготовьтесь к остановке.")
    }
}

// Красный свет
class RedState : TrafficLightState {
    override fun handle() {
        println("Горит красный свет. Стоять!")
    }
}

// Класс светофора, который использует состояния
class TrafficLight(var state: TrafficLightState) {
    fun changeState(newState: TrafficLightState) {
        state = newState
    }

    fun requestState() {
        state.handle()
    }
}