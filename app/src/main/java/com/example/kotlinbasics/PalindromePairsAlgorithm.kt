package com.example.kotlinbasics

fun main() {
    val words = listOf("bat", "tab", "cat", "tac", "abc")
    val palindromePairResult = palindromePairsPP(words)

    println("Palindrome Pairs:")
    for (pair in palindromePairResult) {
        println("${words[pair[0]]}, ${words[pair[1]]}")
    }
}

fun isPalindromePP(str: String): Boolean {
    val length = str.length
    for (i in 0 until length / 2) {
        if (str[i] != str[length - i - 1]) {
            return false
        }
    }
    return true
}

fun palindromePairsPP(words: List<String>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in words.indices) {
        for (j in i + 1 until words.size) {
            val pair1 = words[i] + words[j]
            val pair2 = words[j] + words[i]

            if (isPalindromePP(pair1)) {
                result.add(listOf(i, j))
            }

            if (isPalindromePP(pair2)) {
                result.add(listOf(j, i))
            }
        }
    }

    return result
}