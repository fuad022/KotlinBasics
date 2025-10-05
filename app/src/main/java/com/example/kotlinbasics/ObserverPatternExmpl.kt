package com.example.kotlinbasics

fun main() {
    val subject = Subject()

    val observer1 = ConcreteObserver("Наблюдатель 1")
    val observer2 = ConcreteObserver("Наблюдатель 2")

    subject.addObserver(observer1)
    subject.addObserver(observer2)

    // Наблюдаемый объект уведомляет наблюдателей
    subject.notifyObservers("Сообщение 1")

    // Наблюдатель 1 отписывается
    subject.removeObserver(observer1)

    // Наблюдаемый объект уведомляет остальных наблюдателей
    subject.notifyObservers("Сообщение 2")
}

// Наблюдатель
interface Observer {
    fun update(message: String)
}

// Наблюдаемый объект
class Subject {
    private val observers = mutableListOf<Observer>()

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers(message: String) {
        for (observer in observers) {
            observer.update(message)
        }
    }
}

// Реализация наблюдателя
class ConcreteObserver(private val name: String) : Observer {
    override fun update(message: String) {
        println("$name получил уведомление: $message")
    }
}