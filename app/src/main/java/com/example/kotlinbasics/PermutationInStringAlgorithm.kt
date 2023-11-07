package com.example.kotlinbasics

fun main() {
    val s1 = "ab"
    val s2 = "eidbaooo"

    val result = checkInclusion(s1, s2)
    if (result) {
        println("$s1 is a permutation of a substring of $s2")
    } else {
        println("$s1 is not a permutation of any substring of $s2")
    }
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) {
        return false
    }

    val freqS1 = IntArray(26)
    val freqS2 = IntArray(26)

    for (i in s1.indices) {
        freqS1[s1[i] - 'a']++
        freqS2[s2[i] - 'a']++
    }

    for (i in 0 until s2.length - s1.length) {
        if (freqS1.contentEquals(freqS2)) {
            return true
        }

        freqS2[s2[i] - 'a']--
        freqS2[s2[i + s1.length] - 'a']++
    }

    return freqS1.contentEquals(freqS2)
}