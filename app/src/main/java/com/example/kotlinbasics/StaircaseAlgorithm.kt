package com.example.kotlinbasics

fun main() {
    val height = 5
    drawStaircase(height)
}

fun drawStaircase(height: Int) {
    for (i in 1..height) {
        for (j in 1..height - i) {
            print(" ")
        }

        for (k in 1..i) {
            print("#")
        }

        println()
    }
}