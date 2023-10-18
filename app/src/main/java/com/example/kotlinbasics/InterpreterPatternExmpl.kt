package com.example.kotlinbasics

fun main() {
    val expression = Addition(Number(2), Multiplication(Number(3), Number(4)))

    val result = expression.interpret()
    println("Результат выражения: $result")
}

interface Expression {
    fun interpret(): Int
}

class Number(private val value: Int) : Expression {
    override fun interpret(): Int {
        return value
    }
}

class Addition(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int {
        return left.interpret() + right.interpret()
    }
}

class Multiplication(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Int {
        return left.interpret() * right.interpret()
    }
}