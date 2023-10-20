package com.example.kotlinbasics

fun main() {
    val str1 = "AACD"
    val str2 = "ACDA"

    if (areRotations(str1, str2)) {
        println("$str1 and $str2 are rotations of each other.")
    } else {
        println("$str1 and $str2 are not rotations of each other.")
    }
}

fun areRotations(str1: String, str2: String): Boolean {
    return (str1.length == str2.length) &&
            ((str1 + str2).indexOf(str2) != -1)
}