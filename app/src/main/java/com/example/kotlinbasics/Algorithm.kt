package com.example.kotlinbasics

fun main() {
//    println(reverseString("Hello, World!"))
//    println(isPalindrome(""))
//    println(generateFibonacciSeries(50))
//    println(rotateArrayRight(intArrayOf(1, 2, 3, 4, 5), 2))
    println(twoSum(intArrayOf(2, 7, 11, 15), 9))
}

/*
Reverse a String: Write a algorithm function to reverse a given string in Kotlin.
 */
fun reverseString(input: String): String {
    val charArray = input.toCharArray()
    var start = 0
    var end = input.length - 1

    while (start < end) {
        val temp = charArray[start]
        charArray[start] = charArray[end]
        charArray[end] = temp

        start++
        end--
    }

    return String(charArray)
//    return StringBuilder().append(charArray).toString()
}

/*
Palindrome Check: Write a function to check
if a given string is a palindrome (reads the same forwards and backwards).
 */
fun isPalindrome(input: String): Boolean {
    var start = 0
    var end = input.length - 1

    while (start < end) {
        if (input[start].lowercase() != input[end].lowercase()) {
            return false
        }
        start++
        end--
    }

    return true
}

/*
Fibonacci Series: Write an algorithm function to generate the Fibonacci series up to a given number.
 */
fun generateFibonacciSeries(limit: Int): List<Int> {
    val series = mutableListOf<Int>()

    var prev = 0
    var current = 1

    while (prev <= limit) {
        series.add(prev)

        val next = prev + current
        prev = current
        current = next
    }

    return series
}

/*
Array Rotation: Given an array, write an algorithm function
to rotate the array elements to the right by a given number of steps.
 */
fun rotateArrayRight(array: IntArray, steps: Int): String {
    val rotateArray = IntArray(array.size)

    for (i in array.indices) {
        val newIndex = (i + steps) % array.size
        rotateArray[newIndex] = array[i]
    }

    return rotateArray.joinToString()
}

/*
Two Sum: Given an array of integers and a target number,
write an algorithm function to find two numbers in the array that add up to the target.
 */
fun twoSum(array: IntArray, target: Int): String {
    var twoSumArray = IntArray(2)

    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] + array[j] == target) {
                twoSumArray = intArrayOf(array[i], array[j])
            }
        }
    }

    return twoSumArray.joinToString()
}
