package com.example.kotlinbasics

fun main() {
    val coffee = CoffeeClass()
    val tea = TeaClass()

    println("Making Coffee:")
    coffee.prepareBeverage()

    println("\nMaking Tea:")
    tea.prepareBeverage()
}

abstract class HotBeverage {
    fun prepareBeverage() {
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    abstract fun brew()
    abstract fun addCondiments()

    fun boilWater() {
        println("Boiling water")
    }

    fun pourInCup() {
        println("Pouring into cup")
    }
}

class CoffeeClass : HotBeverage() {
    override fun brew() {
        println("Dripping Coffee through filter")
    }

    override fun addCondiments() {
        println("Adding Sugar and Milk")
    }
}

class TeaClass : HotBeverage() {
    override fun brew() {
        println("Steeping the tea")
    }

    override fun addCondiments() {
        println("Adding Lemon")
    }
}