package com.example.kotlinbasics

fun main() {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Given an array arr[] of size n, write a program to find the maximum and minimum element present in the array.
     */
//    val arr = arrayOf(4, 2, 0, 8, 20, 9, 2)
//    var largest = arr[0]
//    var smallest = arr[0]
//
//    for (num in arr) {
//        if (largest < num)
//            largest = num
//        if (smallest > num)
//            smallest = num
//    }
//    println("Largest: $largest and smallest: $smallest")
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Given an array arr[] of size n, write a program to reverse the array.
     */
//    val arr = arrayOf(4, 5, 1, 2)
//    println(reverse(arr))
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Recursion Factorial
     */
//    countdown(10)
//    println(factorial(4))
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Fibonacci
     */
    println(fibonacci(3))
}

fun reverse(list: Array<Int>): List<Int> {
    val result = arrayListOf<Int>()
    for (i in list.indices) { // list.indices == (0..list.size - 1)
        val number = list[list.size - 1 - i]
        result.add(number)
    }
    return result
}

fun countdown(n: Int) {
    if (n < 1) { // Base Case
        return
    }
    println(n)
    countdown(n - 1) // Recursive
}

fun factorial(n: Long): Long {
    if (n == 0L) { // Base Case
        return 1
    }
    return n * factorial(n - 1) // Recursive Structure
}

fun fibonacci(n: Long): Long {
    if (n <= 1) return n // Base Case
    return fibonacci(n - 1) + fibonacci(n - 2) // Recursive Structure
}






