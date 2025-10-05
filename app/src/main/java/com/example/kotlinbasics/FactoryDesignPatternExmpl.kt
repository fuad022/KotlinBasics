package com.example.kotlinbasics

fun main() {
    val circleFactory: ShapeFactory = CircleFactory()
    val squareFactory: ShapeFactory = SquareFactory()
    val triangleFactory: ShapeFactory = TriangleFactory()

    val circle: Shapes = circleFactory.createShape()
    val square: Shapes = squareFactory.createShape()
    val triangle: Shapes = triangleFactory.createShape()

    circle.draw()    // Вывод: Рисуем круг
    square.draw()    // Вывод: Рисуем квадрат
    triangle.draw()  // Вывод: Рисуем треугольник
}

// Интерфейс фигуры
interface Shapes {
    fun draw()
}

// Конкретная реализация круга
class Circles : Shapes {
    override fun draw() {
        println("Рисуем круг")
    }
}

// Конкретная реализация квадрата
class Square : Shapes {
    override fun draw() {
        println("Рисуем квадрат")
    }
}

// Конкретная реализация треугольника
class Triangles : Shapes {
    override fun draw() {
        println("Рисуем треугольник")
    }
}

// Интерфейс фабрики для создания фигур
interface ShapeFactory {
    fun createShape(): Shapes
}

// Фабрика для создания круга
class CircleFactory : ShapeFactory {
    override fun createShape(): Shapes {
        return Circles()
    }
}

// Фабрика для создания квадрата
class SquareFactory : ShapeFactory {
    override fun createShape(): Shapes {
        return Square()
    }
}

// Фабрика для создания треугольника
class TriangleFactory : ShapeFactory {
    override fun createShape(): Shapes {
        return Triangles()
    }
}