package com.example.kotlinbasics

fun main() {
//    val items = listOf("apple", "banana", "orange")
    val items = mutableListOf("apple", "banana", "orange") // ArrayList

    for (item in items)
        println(item)

    //while
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println(5 in 3..10)

    for (i in 1..10)
        println(i)

    println()
    println()

    for (i in 1 until 10)
        println(i)

    println()
    println()

    for (i in 10 downTo 1)
        println(i)

    println()
    println()

    for (i in 0..100 step 10)
        println(i)
}
