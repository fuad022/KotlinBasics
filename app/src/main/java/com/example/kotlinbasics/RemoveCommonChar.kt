package com.example.kotlinbasics

fun main() {
    removeCommonCharacter("pre destination", "final destination")
}

fun removeCommonCharacter(s1: String, s2: String) {
    var s1 = s1
    var s2 = s2
    println("Before removing common character s1 : $s1")
    println("Before removing common character s2 : $s2")
    var commonChars = ""

    for (i in 0 until s1.length) {
        for (j in 0 until s2.length) {
            if (s1[i] == s2[j]) {
                commonChars += s1[i]
            }
        }
    }

    for (i in 0 until commonChars.length) {
        val charToRemove = commonChars[i] + ""
        s1 = s1.replace(charToRemove, "")
        s2 = s2.replace(charToRemove, "")
    }

    println("After removing common character : $s1")
    println("After removing common character : $s2")
}