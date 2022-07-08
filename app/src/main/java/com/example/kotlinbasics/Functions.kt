package com.example.kotlinbasics

import java.util.*

fun main() {
//    println(testSimple(3, 10))
//    println(testNamedArguments(4, 2, 5))
//    printEven(5, 8, 9, 6, 7)
//    printEven(*intArrayOf(1, 2, 3, 4, 5), 6, 7, 8, 9, 10)

//    val nums = intArrayOf(1, 2, 3, 4)
//    val intNum = 2
//    changeNumbers(*nums, koef = intNum)

    val c = Calendar.getInstance()
    val hour = c.get(Calendar.HOUR_OF_DAY)
    val minute = c.get(Calendar.MINUTE)
    val timeStamp = "$hour:$minute"
    println(timeStamp)
}

//fun testSimple(): Int {
//    return 5 + 5
//}

fun testSimple(x: Int, y: Int): Int = x + y

fun testNamedArguments(x: Int, y: Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}

fun changeNumbers(vararg numbers: Int, koef: Int) {
    for (number in numbers)
        println(number * koef)
}
