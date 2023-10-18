package com.example.kotlinbasics

fun main() {
    val candyFactory: CandyFactory = FancyCandyFactory()
    val chocolateCandy: Candy = candyFactory.createChocolateCandy()
    chocolateCandy.eat()

    val drinkFactory: DrinkFactory = FancyDrinkFactory()
    val soda: Drink = drinkFactory.createSoda()
    soda.consume()
}

interface CandyFactory {
    fun createChocolateCandy(): Candy
}

interface DrinkFactory {
    fun createSoda(): Drink
}

interface Candy {
    fun eat()
}

interface Drink {
    fun consume()
}

class ChocolateCandy : Candy {
    override fun eat() {
        println("Enjoying chocolate candy")
    }
}

class Soda : Drink {
    override fun consume() {
        println("Drinking soda")
    }
}

class FancyCandyFactory : CandyFactory {
    override fun createChocolateCandy(): Candy {
        return ChocolateCandy()
    }
}

class FancyDrinkFactory : DrinkFactory {
    override fun createSoda(): Drink {
        return Soda()
    }
}