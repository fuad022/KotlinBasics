package com.example.kotlinbasics

fun main() {
    // Используем FancyCandyFactory для создания шоколадных конфет
    val candyFactory: CandyFactory = FancyCandyFactory()
    val chocolateCandy: Candy = candyFactory.createChocolateCandy()
    chocolateCandy.eat()

    // Используем FancyDrinkFactory для создания газированных напитков
    val drinkFactory: DrinkFactory = FancyDrinkFactory()
    val soda: Drink = drinkFactory.createSoda()
    soda.consume()
}

// Абстрактная фабрика для конфет
interface CandyFactory {
    fun createChocolateCandy(): Candy
}

// Абстрактная фабрика для напитков
interface DrinkFactory {
    fun createSoda(): Drink
}

// Абстрактный класс конфеты
interface Candy {
    fun eat()
}

// Абстрактный класс напитка
interface Drink {
    fun consume()
}

// Конкретная реализация шоколадных конфет
class ChocolateCandy : Candy {
    override fun eat() {
        println("Enjoying chocolate candy")
    }
}

// Конкретная реализация газированного напитка
class Soda : Drink {
    override fun consume() {
        println("Drinking soda")
    }
}

// Конкретная реализация фабрики конфет
class FancyCandyFactory : CandyFactory {
    override fun createChocolateCandy(): Candy {
        return ChocolateCandy()
    }
}

// Конкретная реализация фабрики напитков
class FancyDrinkFactory : DrinkFactory {
    override fun createSoda(): Drink {
        return Soda()
    }
}