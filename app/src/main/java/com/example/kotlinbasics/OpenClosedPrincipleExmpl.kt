package com.example.kotlinbasics

fun main() {
    val square = SquareOCP(4.0)
    val circle = CircleOCP(3.0)

    val shapes = listOf(square, circle)

    val total = totalAreaOCP(shapes)
    println("Общая площадь фигур: $total")
}

abstract class ShapeOCP {
    abstract fun area(): Double
}

class SquareOCP(val sideLength: Double) : ShapeOCP() {
    override fun area(): Double {
        return sideLength * sideLength
    }
}

class CircleOCP(val radius: Double) : ShapeOCP() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

fun totalAreaOCP(shapes: List<ShapeOCP>): Double {
    var total = 0.0
    for (shape in shapes) {
        total += shape.area()
    }
    return total
}