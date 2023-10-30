package com.example.kotlinbasics

fun main() {
    println("Original set:")
    val names = mutableListOf("Demetrius")
    val nameSet = OrderedSet(names)
    println(nameSet)
    val n1 = "Adam"
    println("Adding $n1 to the list:")
    nameSet.insert(n1)
    println(nameSet)
    val n2 = "Tim"
    println("Adding $n2 to the list:")
    nameSet.insert(n2)
    println(nameSet)
    val n3 = "Zack"
    println("Adding $n3 to the list:")
    nameSet.insert(n3)
    println(nameSet)
    val n4 = "Ali"
    println("Try Add $n4 again to the list:")
    nameSet.insert(n4)
    println(nameSet)

    nameSet.remove(n2)
    println("Removing $n2 from the list:")
    println(nameSet)
    nameSet.remove(n4)
    println("Removing $n4 from the list:")
    println(nameSet)
    nameSet.remove(n1)
    println("Removing $n1 from the list:")
    println(nameSet)
}

class OrderedSet<T : Comparable<T>>(list: MutableList<T>) {
    private var items: MutableList<T> = list
    fun insert(element: T) {
        if (exists(element)) {
            return
        }
        for (i in 0 until this.items.count()) {
            if (this.items[i] > element) {
                this.items.add(i, element)
                return
            }
        }
        this.items.add(element)
    }

    private fun findElementPosition(element: T): Int? {
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
        return null
    }

    override fun toString(): String = this.items.toString()

    fun isEmpty(): Boolean = this.items.isEmpty()
    private fun exists(element: T): Boolean = findElementPosition(element) != null
    private fun count(): Int = this.items.count()
    fun remove(element: T) {
        val position = findElementPosition(element)
//        if (position != null) {
//            this.items.removeAt(position)
//        }
        position?.let {
            this.items.removeAt(position)
        }
    }

    fun removeAll() = this.items.removeAll(this.items)
    fun max(): T? {
        return if (count() != 0) {
            this.items[count() - 1]
        } else {
            null
        }
    }

    fun min(): T? {
        return if (count() != 0) {
            this.items[0]
        } else {
            null
        }
    }
}