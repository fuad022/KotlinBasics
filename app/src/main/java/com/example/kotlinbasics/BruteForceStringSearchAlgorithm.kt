package com.example.kotlinbasics

fun main() {
    val text = "This is a test text"
    val pattern = "test"

    val index = bruteForceStringSearch(text, pattern)
    if (index != -1) {
        println("Pattern found at index $index")
    } else {
        println("Pattern not found in the text")
    }
}

fun bruteForceStringSearch(text: String, pattern: String): Int {
    val n = text.length
    val m = pattern.length

    if (m > n) return -1 // Pattern length is greater than text length

    for (i in 0..n - m) {
        var j = 0
        while (j < m && text[i + j] == pattern[j]) {
            j++
        }
        if (j == m) {
            return i // Pattern found at index i in the text
        }
    }

    return -1 // Pattern not found in text
}