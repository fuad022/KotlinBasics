package com.example.kotlinbasics

import kotlinx.coroutines.*

//class SynchronizationExmpl {

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    var sharedCounter = 0
    val scope = CoroutineScope(newFixedThreadPoolContext(4, "synchronizationPool"))
    scope.launch {
        val coroutines = 1.rangeTo(1000).map {
            launch {
                for (i in 1..1000) {
                    sharedCounter++
                }
            }
        }

        coroutines.forEach { coroutine ->
            coroutine.join()
        }
    }.join()

    println("The number of shared counter should be 10 000 000, but actually is $sharedCounter")
}

//}