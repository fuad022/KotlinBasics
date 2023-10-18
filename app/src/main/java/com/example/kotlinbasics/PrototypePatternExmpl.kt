package com.example.kotlinbasics

fun main() {
    // Создаем оригинальный объект
    val original = ConcretePrototype(42)

    // Клонируем объект
    val clone = original.clones()

    // Выводим результат
    println("Original: $original")
    println("Clone: $clone")
}

// Интерфейс, который реализует Cloneable
interface Prototype : Cloneable {
    fun clones(): Prototype
}

// Класс, реализующий интерфейс Prototype
data class ConcretePrototype(val data: Int) : Prototype {
    override fun clones(): Prototype {
        return ConcretePrototype(this.data)
    }
}