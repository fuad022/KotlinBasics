package com.example.kotlinbasics

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

//fun main() = runBlocking<Unit> {
//    val numbersFlow = flowOf(1, 2, 3, 4, 5, 6)
//
//    numbersFlow
//        .flatMapLatest { number ->
//            flow {
//                delay(Random.nextLong(100, 1000)) // задержка
//                emit("Number: $number")
//            }
//        }
//        .collect { println(it) }
//}

//fun main() = runBlocking<Unit> {
//    val flow = flowOf(1, 2, 3)
//
//    flow.flatMapConcat { value ->
//        flow {
//            emit(value)
//            emit(value * 10)
//        }
//    }
//        .collect { println(it) }
//}

//fun main() = runBlocking<Unit> {
//    val numbersFlow = flowOf(1, 2, 3)
//    val lettersFlow = flowOf("A", "B", "C")
//
//    numbersFlow.zip(lettersFlow) { number, letter ->
//        "$number$letter"
//    }
//        .collect { println(it) }
//}

//fun main() = runBlocking<Unit> {
//    val flow1 = flowOf(1, 2, 3)
//    val flow2 = flowOf("A", "B", "C")
//    val flow3 = flowOf(true, false, true)
//
//    flow1.zip(flow2) { value1, value2 ->
//        value1 to value2
//    }.zip(flow3) { tuple, value3 ->
//        Triple(tuple.first, tuple.second, value3)
//    }.collect { triple ->
//        println(triple)
//    }
//}

//fun main() = runBlocking {
//    val flow = flowOf(1, 2, 3, 4, 5)
////    val flow = flowOf("A", "B", "C")
//
//    val sum = flow.reduce { accumulator, value ->
//        accumulator + value
//    }
//
//    println("Sum: $sum")
//}

fun main() = runBlocking<Unit> {
    val coldFlow = flowOf(1, 2, 3, 4, 5)

    coldFlow.collect { println(it) } // Первый подписчик

    delay(1000) // Задержка 1 секунда

    coldFlow.collect { println(it) } // Второй подписчик
}