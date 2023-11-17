package com.example.kotlinbasics

fun main() {
    val number = 19 // Change the number to check if it's a happy number
    if (isHappyNumber(number)) {
        println("$number is a happy number.")
    } else {
        println("$number is not a happy number.")
    }
}

fun isHappyNumber(n: Int): Boolean {
    var num = n
    val seen = HashSet<Int>()

    while (num != 1 && !seen.contains(num)) {
        seen.add(num)
        var sum = 0
        while (num > 0) {
            val digit = num % 10
            sum += digit * digit
            num /= 10
        }
        num = sum
    }

    return num == 1
}