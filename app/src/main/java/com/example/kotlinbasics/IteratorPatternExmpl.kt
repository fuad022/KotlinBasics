package com.example.kotlinbasics

fun main() {
    val collection = ConcreteAggregate(listOf("A", "B", "C", "D", "E"))
    val iterator = collection.iterator()

    while (iterator.hasNext()) {
        val item = iterator.next()
        println(item)
    }
}

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

interface Iterables<T> {
    fun iterator(): Iterator<T>
}

class ConcreteIterator<T>(private val items: List<T>) : Iterator<T> {
    private var position = 0

    override fun hasNext(): Boolean {
        return position < items.size
    }

    override fun next(): T {
        if (hasNext()) {
            return items[position++]
        }
        throw NoSuchElementException("No more elements")
    }
}

class ConcreteAggregate<T>(private val items: List<T>) : Iterables<T> {
    override fun iterator(): Iterator<T> {
        return ConcreteIterator(items)
    }
}