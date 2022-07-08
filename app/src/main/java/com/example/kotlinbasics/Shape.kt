package com.example.kotlinbasics

abstract class Shape(
    var name: String
) {
    init {
        println("I am the super class!")
    }

    abstract fun area(): Double

    abstract fun perimeter(): Double

    fun changeName(newName: String) {
        name = newName
    }
}