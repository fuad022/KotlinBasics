package com.example.kotlinbasics

fun main() {
    val n = 3
    println("Balanced Brace Combinations for $")
    printBalancedBraces(n)
}

fun printBalancedBraces(n: Int) {
    val output = CharArray(2 * n)
    printBalancedBracesHelper(output, 0, n, 0, 0)
}

fun printBalancedBracesHelper(output: CharArray, index: Int, n: Int, open: Int, close: Int) {
    // If all braces are placed, print the combination
    if (index == 2 * n) {
        println(output.joinToString(""))
    }

    // Add an opening brace if there are remaining open braces
    if (open < n) {
        output[index] = '{'
        printBalancedBracesHelper(output, index + 1, n, open + 1, close)
    }

    // Add a closing brace if it creates a balanced combination
    if (close < open) {
        output[index] = '}'
        printBalancedBracesHelper(output, index + 1, n, open, close + 1)
    }
}