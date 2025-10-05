package com.example.kotlinbasics

import kotlin.random.Random

fun main() {
    val min = 1
    val max = 100

    val randomValue = pickRandom(min, max)
    println("Случайное число в диапазоне от $min до $max: $randomValue")
}

fun pickRandom(min: Int, max: Int): Int {
    // Генерируем случайное число в диапазоне от min до max включительно
    return Random.nextInt(min, max + 1)
}