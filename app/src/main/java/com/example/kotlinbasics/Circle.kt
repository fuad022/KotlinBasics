package com.example.kotlinbasics

class Circle(
    val radius: Double
) : Shape("Circle") {
    val pi = 3.141592

    init {
        println("$name created with radius = $radius")
        println("$name area is ${area()}")
        println("$name perimeter is ${perimeter()}")
    }

    override fun area() = radius * radius * pi

    override fun perimeter() = 2 * radius * pi
}