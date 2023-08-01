package com.example.kotlinbasics

fun main() {
    println(countLetters("AAAAABBBBBCCXYZDDDDDEEEEEFFFFAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"))

    val arr = arrayOfNulls<Int>(5)
    arr[0] = 1
    arr[1] = 2
    arr[2] = 3
    arr[3] = 4
    arr[4] = 5
    println(arr.contentToString())


    val numbers = listOf(1, 2, 3, 4, 5)

    // Пример с использованием it в лямбда-выражении
    val squaredNumbers = numbers.map { it * it }

    // Пример с использованием it в аргументе функции
    fun printNumber(number: Int) {
        println("Number: $number")
    }

    numbers.forEach { printNumber(it) }
}

fun countLetters(str: String): String {
    var currentLetter = str[0]
    var count = 1
    var result = ""

    for (letter in str.substring(1)) {
        if (currentLetter == letter) {
            count++
        } else {
            if (count == 1)
                result += currentLetter
            else
                result += "$currentLetter$count"

            count = 1
            currentLetter = letter
        }
    }

    if (count == 1)
        result += currentLetter
    else
        result += "$currentLetter$count"

    return result
}
