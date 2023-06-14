//@file:Suppress("unused")

package com.example.kotlinbasics

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.security.auth.callback.Callback

suspend fun main() {
    doSomeWork()
}

suspend fun doSomeWork() {
    supervisorScope {
        launch {
            delay(1000)
            println("Tasl 1 completed")
        }
        launch {
            delay(2000)
            throw Exception("Error")
        }
        launch {
            delay(3000)
            println("Task 3 completed")
        }
    }
    println("All tasks completed")
}

//fun main(): Unit = runBlocking {
//    val coroutines: List<Deferred<String>> = List(100) {
//        async(start = CoroutineStart.DEFAULT) {
//            doWork(it.toString())
//        }
//    }
//    coroutines.forEach { it.cancelAndJoin() }
//}
//
//suspend fun doWork(name: String): String {
//    delay(Random().nextInt(5000).toLong())
//    return "Done. $name"
//}

//// Реализовать оператор который эмитит только изменившееся значение
//fun <T> Flow<T>.unique(): Flow<T> = flow {
//    var lastValue: Any? = NoValue
//    collect { value: T ->
//        if (lastValue != value) {
//            lastValue = value
//            emit(value)
//        }
//    }
//}

/*
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
}*/

interface Request<T> {
    fun execute(callback: Callback<T>)
    fun cancel()

    interface Callback<T> {
        fun onSuccess(value: T)
        fun onError(e: Exception)
    }
}

fun <T> Request<T>.asFlow(): Flow<T> {
    return callbackFlow {
        execute(object : Request.Callback<T> {
            override fun onSuccess(value: T) {
                trySend(value)
            }

            override fun onError(e: Exception) {
                close(e)
            }
        })
        awaitClose { this@asFlow.cancel() }
    }
}




























