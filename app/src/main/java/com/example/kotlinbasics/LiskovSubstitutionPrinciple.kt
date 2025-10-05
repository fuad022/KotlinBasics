package com.example.kotlinbasics

fun main() {
    val rectangle = RectangleLSP(5.0, 3.0)
    val circle = CircleLSP(4.0)

    println("Rectangle area: ${calculateArea(rectangle)}")
    println("Circle area: ${calculateArea(circle)}")
}

open class ShapeLSP {
    open fun area(): Double {
        return 0.0
    }
}

class RectangleLSP(val width: Double, val height: Double) : ShapeLSP() {
    override fun area(): Double {
        return width * height
    }
}

class CircleLSP(val radius: Double) : ShapeLSP() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

fun calculateArea(shape: ShapeLSP): Double {
    return shape.area()
}