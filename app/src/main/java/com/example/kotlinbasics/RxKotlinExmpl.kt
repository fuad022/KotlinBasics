package com.example.kotlinbasics

import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable

fun main() {
    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    list.toObservable()
        .filter { it.length >= 5 }
        .subscribeBy(
            onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("Done!") }
        )

}