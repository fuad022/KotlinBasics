package com.example.kotlinbasics

fun main() {
    // Получение экземпляра одиночки
    val singletonInstance1 = SingletonExample
    val singletonInstance2 = SingletonExample

    // Изменение данных через один из экземпляров
    singletonInstance1.data = "Updated data"

    // Оба экземпляра ссылаются на один и тот же объект
    singletonInstance1.printData()
    singletonInstance2.printData()
}

object SingletonExample {
    var data: String = "Initial data"

    fun printData() {
        println(data)
    }
}