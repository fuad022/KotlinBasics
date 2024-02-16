package com.example.kotlinbasics

fun main() {
    val text = "this is a test text"
    val pattern = "test"
    val index = boyerMooreSearch(text, pattern)
    if (index != -1) {
        println("Pattern found at index $index")
    } else {
        println("Pattern not found")
    }
}

fun boyerMooreSearch(text: String, pattern: String): Int {
    val lastOccurrence = buildLastOccurrence(pattern)

    var i = pattern.length - 1
    var j = pattern.length - 1

    while (i < text.length) {
        if (text[i] == pattern[j]) {
            if (j == 0) {
                return i // match found
            }
            i--
            j--
        } else {
            val lastOcc = lastOccurrence[text[i]] ?: -1
            i += pattern.length - Math.min(j, 1 + lastOcc)
            j = pattern.length - 1
        }
    }
    return -1 // no match found
}

fun buildLastOccurrence(pattern: String): Map<Char, Int> {
    val lastOccurance = mutableMapOf<Char, Int>()
    for (i in pattern.indices) {
        lastOccurance[pattern[i]] = i
    }
    return lastOccurance
}