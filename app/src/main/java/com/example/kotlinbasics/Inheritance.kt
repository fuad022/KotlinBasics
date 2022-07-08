package com.example.kotlinbasics

fun main() {
    val myCircle1 = Circle(5.0)
    myCircle1.changeName("Peter")
    println(myCircle1.name)

    val myTrangle = Triangle(3.0, 3.0, 5.0)
    myTrangle.changeName("Susan")
    println(myTrangle.name)
}