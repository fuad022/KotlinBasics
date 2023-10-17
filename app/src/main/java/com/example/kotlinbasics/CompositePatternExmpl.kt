package com.example.kotlinbasics

// Пример использования
fun main() {
    val leaf1 = Leaf("Leaf 1")
    val leaf2 = Leaf("Leaf 2")
    val leaf3 = Leaf("Leaf 3")

    val composite1 = Composite("Composite 1")
    composite1.add(leaf1)
    composite1.add(leaf2)

    val composite2 = Composite("Composite 2")
    composite2.add(leaf3)

    val rootComposite = Composite("Root Composite")
    rootComposite.add(composite1)
    rootComposite.add(composite2)

    // Вызываем операцию на корневом композите
    rootComposite.operation()
}

// Общий интерфейс для всех компонентов
interface Component {
    fun operation()
}

// Конкретный класс для простого объекта
class Leaf(private val name: String) : Component {
    override fun operation() {
        println("Leaf: $name")
    }
}

// Класс для составного объекта (контейнера)
class Composite(private val name: String) : Component {
    private val children = mutableListOf<Component>()

    fun add(component: Component) {
        children.add(component)
    }

    override fun operation() {
        println("Composite: $name")
        for (child in children) {
            child.operation()
        }
    }
}