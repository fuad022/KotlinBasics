package com.example.kotlinbasics

import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val counter = AtomicInteger(0)

    // Создаем 10 потоков, каждый из которых инкрементирует счетчик 1000 раз
    val threads = List(10) {
        Thread {
            for (i in 1..1000) {
                counter.incrementAndGet()
            }
        }
    }

    // Запускаем потоки
    threads.forEach {
        it.start()
    }

    // Ждем завершения потоков
    threads.forEach {
        it.join()
    }

    
    // Выводим результат
    println("Counter value: ${counter.get()}")
}