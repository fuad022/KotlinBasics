package com.example.kotlinbasics

import android.annotation.SuppressLint
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable

@SuppressLint("CheckResult")
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