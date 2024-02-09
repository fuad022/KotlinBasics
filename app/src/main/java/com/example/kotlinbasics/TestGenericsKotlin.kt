package com.example.kotlinbasics

//class Container<T>(val value: T)
//class Container<out T>(val value: T)

inline fun calculate(x: Int, y: Int): Int {
    return x + y
}

fun main() {
//    val intContainer: Container<Int> = Container(10)
//    val anyContainer: Container<Any> = Container("Hello")
//
////    Type mismatch
//    val anyContainer2: Container<Any> = intContainer

    val result = calculate(3, 4)
    println(result)
}