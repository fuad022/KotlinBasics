package com.example.kotlinbasics

fun main() {
    val simpleCoffee: Coffee = SimpleCoffee()
    println("Cost: ${simpleCoffee.cost()}, Description: ${simpleCoffee.description()}")

    val milkCoffee: Coffee = MilkDecorator(simpleCoffee)
    println("Cost: ${milkCoffee.cost()}, Description: ${milkCoffee.description()}")

    val sweetMilkCoffee: Coffee = SugarDecorator(milkCoffee)
    println("Cost: ${sweetMilkCoffee.cost()}, Description: ${sweetMilkCoffee.description()}")
}

interface Coffee {
    fun cost(): Double
    fun description(): String
}

class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 2.0
    }

    override fun description(): String {
        return "Simple coffee"
    }
}

class MilkDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost() + 1.0
    }

    override fun description(): String {
        return coffee.description() + ", milk"
    }
}

class SugarDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost() + 0.5
    }

    override fun description(): String {
        return coffee.description() + ", sugar"
    }
}