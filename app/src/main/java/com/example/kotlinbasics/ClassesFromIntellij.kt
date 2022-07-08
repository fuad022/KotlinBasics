package com.example.kotlinbasics

fun main() {
    val child = Person1("Child", "Child", 1)
    val p1 = Person1("Tom", "Jones", 35, child)
    println(p1.firstName)

    val rectangle1 = Rectangle1(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}")

    val rectangle2 = Rectangle1(5.0, 2.0)
    println(rectangle1 == rectangle2)

}

class Person1(val firstName: String, val lastName: String, var age: Int) {
    var children: MutableList<Person1> = mutableListOf()

    init {
        println("Person is created $firstName")
    }

    constructor(firstName: String, lastName: String, age: Int, child: Person1) : this(firstName, lastName, age) {
        children.add(child)
    }

    constructor() : this("", "", -1)

}

data class Rectangle1(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2

    var test = 1
        get() = field + 1
        set(value) {
            if (value < 0) println("Negative value")
            field = value
        }

    fun area() = height * length
}