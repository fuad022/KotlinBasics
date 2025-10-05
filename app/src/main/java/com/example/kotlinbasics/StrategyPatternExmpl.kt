package com.example.kotlinbasics

fun main() {
    val editor = GraphicEditor()

    val circle = CircleClass()
    val square = SquareClass()

    editor.setShape(circle)
    editor.draw()

    editor.setShape(square)
    editor.draw()
}

class CircleClass : ShapeClass {
    override fun draw() {
        println("Рисую круг")
    }
}

class SquareClass : ShapeClass {
    override fun draw() {
        println("Рисую квадрат")
    }
}

interface ShapeClass {
    fun draw()
}

class GraphicEditor {
    private var currentShape: ShapeClass? = null

    fun setShape(shape: ShapeClass) {
        currentShape = shape
    }

    fun draw() {
        currentShape?.draw()
    }
}