package com.example.kotlinbasics

fun main() {
    println("Original list:")
    val names = listOf(
        "Tim",
        "Steve",
        "Zack",
        "Adam",
        "John",
        "Peter",
        "Clark"
    ) as MutableList<String>
    println(names)
    println("Ordered list:")
    val ordered = OrderedArray<String>(names)
    println(ordered)
    val n1 = "Paul"
    println("Adding $n1 to the list:")
    ordered.insert(n1)
    println(ordered)
    val n2 = "Demetrius"
    println("Adding $n2 to the list:")
    ordered.insert(n2)
    println(ordered)
}

class OrderedArray<T : Comparable<T>>(list: MutableList<T>) {
    private var items: MutableList<T> = this.quicksort(list) as MutableList<T>

    private fun quicksort(its: List<T>): List<T> {
        if (its.isEmpty()) return its
        val pivot = its[its.count() / 2]
        val equal = its.filter { it == pivot }
        val less = its.filter { it < pivot }
        val greater = its.filter { it > pivot }
        return quicksort(less) + equal + quicksort(greater)
    }

    fun insert(element: T) {
        val position = findElementPosition(element)
        this.items.add(position, element)
    }

    private fun findElementPosition(element: T): Int {
        var rangeStart = 0
        var rangeEnd = this.items.count()
        while (rangeStart < rangeEnd) {
            val midIndex = rangeStart + (rangeEnd - rangeStart) / 2
            if (this.items[midIndex] == element) {
                return midIndex
            } else if (this.items[midIndex] < element) {
                rangeStart = midIndex + 1
            } else {
                rangeEnd = midIndex
            }
        }
        return rangeStart
    }

    override fun toString(): String = this.items.toString()
}