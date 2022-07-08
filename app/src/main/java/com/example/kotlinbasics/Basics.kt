package com.example.kotlinbasics

import java.util.*

fun main() {
//    var myNum = 5
//    myNum += 3
//
//    println("myNum is $myNum")
//
//    myNum++
//    println("myNum is $myNum")
//    println("myNum is ${myNum++}")
//    println("myNum is ${++myNum}")

//    println(tribonacci(10))

//    repeat(3) {
//        println("Hello repeat")
//    }

//    val a: String? = null
//    val b: String? = null
//    val res = a + b
//    println(res)

//    var name: Any = "Tom"
//    println(name)
//    name = 6578
//    println(name)

//    print("Enter name: ")
//    val name = readLine()
//    println("Enter name: $name")

//    val z = 3 shl 2
//    println(z)
//    val d = 0b1100 shr 2
//    println(d)

//    val x = 5 // 101
//    val y = 6 // 110
////    val z = x and y // z = 101 & 110 = 100
////    println(z)
////    val d = 0b101 and 0b110
////    println(d)
////    val z = x or y // z = 101 | 110 = 111
////    println(z) // z = 7
////    val d = 0b101 or 0b110
////    println(d)
//    val z = x xor y // z = 101 ^ 110 = 011
//    println(z) // z = 3
//    val d = 0b101 xor 0b110
//    println(d) // d = 3

//    val b = 11 // 1011
//    val c = b.inv()
//    println(c) // -12

//    val b = Arrays.asList(2, 401, 402, 393).contains(2)
//    println(b)

//    var name: String? = "Fuad"
////    name = null
//
//    var len2 = name?.length
//    name?.let {
//        println(it.length)
//    }

    val char = '#'
//    val uni = String.format("u+%04x", char.code).uppercase()
    val uni = String.format("u+%04x", '#'.code).uppercase()
    println(uni)
}

class Person {
    var name: String = "defaultValue"
        get() = field
        set(value) {
            field = value
        }
}

fun tribonacci(n: Int): Int {
    val t = arrayOf(0, 1, 1)
    val lastIndex = t.lastIndex
    repeat(n - lastIndex) {
        val next = t.sum()
        t[0] = t[1]
        t[1] = t[2]
        t[2] = next
    }

//    val min = t[minOf(n, t.lastIndex)]
    val min = minOf(n, lastIndex)
    val lastIndexArr = t[min]

    return lastIndexArr
}

fun tribonacciNumber(num: Int): Int {

    if (num == 1 || num == 2) return 0
    if (num == 3) return 1

    return tribonacciNumber(num - 1) +
            tribonacciNumber(num - 2) +
            tribonacciNumber(num - 3)
}
