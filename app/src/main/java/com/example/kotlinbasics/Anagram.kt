package com.example.kotlinbasics

import java.util.Arrays

fun main() {
    val str1 = "mother in law"
    val str2 = "women hitler"

    val isAnagram = Arrays.equals(
        str1.chars().sorted().toArray(),
        str2.chars().sorted().toArray()
    )

    if (isAnagram) {
        println("$str1 and $str2 are an anagrams of each other")
    } else {
        println("$str1 and $str2 are not anagrams of each other")
    }
}