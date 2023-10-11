package com.example.kotlinbasics

fun main() {
    val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
    val emailString = "example@email.com"

    if (emailPattern.matches(emailString)) {
        println("Email is valid!")
    } else {
        println("Email is not valid.")
    }
}