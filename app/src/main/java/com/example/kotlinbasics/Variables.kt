package com.example.kotlinbasics

fun main() {
    val b: Long = 45L
    val c: Float = 68.71F
    val d: Double = 68.71
    val a: Boolean = false
    val e: Int = 0x0A1
    val e1: Int = 161
    val f: Char = 'A'


    val test1 = 3
    var test2 = 4

    println("Value of test1 $test1")
    println("Sum of test1 and test2 ${test1 + test2}")
    println("Sum is ${2 + 2}")

    val text: String = """SALT II was a series of talks between United States
and Soviet negotiators from 1972 to 1979.
It was a 
continuation of the SALT I talks."""
    println(text)

    var name: Any = "Tom Smith"
    name = 6758
}
