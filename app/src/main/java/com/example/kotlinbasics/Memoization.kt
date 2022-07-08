package com.example.kotlinbasics

import java.math.BigInteger

fun main() {
//    println(fib2(10, ""))
    println(fib1(10))
}

fun fib1(n: Int): BigInteger {
    return fib3(n, BigInteger.ZERO, BigInteger.ONE)
}

fun fib3(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    println("fib($n, $a, $b)")
    return if (n == 0) {
        countStackFrames()
        a
    } else {
        fib3(n - 1, b, a + b)
    }
}

fun countStackFrames() {
    val trace = Thread.currentThread().stackTrace
    println(trace.size)
    for (entry in trace.groupingBy { it }.eachCount()) {
        println(entry)
    }
}

//val cache = mutableMapOf(
//    0 to BigInteger.ZERO,
//    1 to BigInteger.ONE
//)

//fun fib2(n: Int, chain: String): BigInteger {
//    val chain = "$chain $n"
//    println(chain)
//    return cache.getOrPut(n) {
//        val a = fib2(n - 2, chain)
//        val b = fib2(n - 1, chain)
//        println(chain)
//        a + b
//    }
//}