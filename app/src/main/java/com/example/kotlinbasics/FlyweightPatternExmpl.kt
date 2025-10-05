package com.example.kotlinbasics

fun main() {
    val circleFactory = CircleFactory1()

    val redCircle = circleFactory.getCircle("красный")
    val blueCircle = circleFactory.getCircle("синий")
    val greenCircle = circleFactory.getCircle("зеленый")

    redCircle.render("красный")
    blueCircle.render("синий")
    greenCircle.render("зеленый")

    // Также можно создавать круги с одним цветом снова и снова,
    // но фактически создается только один объект для каждого цвета
    val anotherRedCircle = circleFactory.getCircle("красный")
    anotherRedCircle.render("красный")
}

// Интерфейс для объектов, поддерживающих отображение
interface Renderable {
    fun render(color: String)
}

// Конкретная реализация объекта с внешним состоянием (цвет)
class Circle1(private val radius: Int) : Renderable {
    override fun render(color: String) {
        println("Отрисовка круга радиксом $radius и цветом $color")
    }
}

// Фабрика для создания кругов с использованием Flyweight Pattern
class CircleFactory1 {
    private val circleCache = mutableMapOf<String, Renderable>()

    fun getCircle(color: String): Renderable {
        return circleCache.getOrPut(color) { Circle1(10) }
    }
}