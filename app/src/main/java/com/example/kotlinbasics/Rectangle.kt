package com.example.kotlinbasics

class Rectangle(
    val a: Double,
    val b: Double
) : Shape("Rectangle") {
    init {
        println("$name created with a = $a and b = $b")
    }

    fun area() = a * b

    fun perimeter() = 2 * a + 2 * b

    fun isSquare() = a == b
}