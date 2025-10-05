package com.example.kotlinbasics

fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(5, 6, 1, 2, 3, 4, 5)

    if (isSublist(list1, list2)) {
        println("List1 is a sublist of List2")
    } else {
        println("List1 is not a sublist of List2")
    }
}

fun isSublist(list1: List<Int>, list2: List<Int>): Boolean {
    var i = 0
    var j = 0

    while (i < list1.size && j < list2.size) {
        if (list1[i] == list2[j]) {
            i++
        }
        j++
    }

    return i == list1.size
}