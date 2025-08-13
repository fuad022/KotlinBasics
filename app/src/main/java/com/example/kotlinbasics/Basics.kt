package com.example.kotlinbasics

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    /*
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
     */

    /*
//    val instant =  Instant.parse("2018-01-28T08:00:59.394Z")
//    println(instant)

//    val ldt = LocalDateTime.parse("2018-01-28T08:00:59.394Z")
//    val instant = ldt.atZone(ZoneId.systemDefault()).toInstant()

//    val zonedDateTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        ZonedDateTime.parse("2018-01-28T08:00:59.394Z")
//    } else {
//        TODO("VERSION.SDK_INT < O")
//    }

//    val monthList = ArrayList<String>()
//    monthList.add("January")
//    monthList.add("February")
//    monthList.add("March")
//    monthList.add("April")
//    monthList.add("May")
//    println(monthList)
//    monthList.clear()
//    println(monthList.isEmpty())*/

//    val str = "aa ddd "
//    println(str.trim().length)

    /*
    val url = "https://ib.rabitabank.com/MobileApi?svc=ips&signlist=ecd%2Cpanmask%2Crnd%2Csvc%2Csignlist" +
            "%2Cfp&ecd=EURM9l9Ic599OYlNwZoMpwtgynOdCMKbKGl9uw6XlVAx8QbcMfBPR5mZfg3s-fmvl_fYsTZAhLXymeC6" +
            "uhYnRcB5EWyfgwy4_mHv8eaEkZZKJVGmx3gk61iO2yviMvb3-xhU4Ys4BgdaFvWbSZm3E6HozN4anEz_HbIuYsK4_E8kp" +
            "bgMli9IYoH5qP-8fi5kQvOB3wV4Zyj1shwEsMBMfRmcM6rlsSbsGL6qVnTCiQXEjwAPvBFmzfQLORybbtzm7zQGYUTHBx" +
            "QOsswXMZf95kvuSwN-71E3k_u3ZQ31kGpL4iD5awIhAVY_mh-CSNHJ5aGBWGW0IU4hi8ex4SC_dvE%3D&panmask=*89" +
            "91&sign=R4ycT4fdRQoC3NBpdtkqNVsJAojgEs9aTjxu6ZKzy57TCUgAbHOMa1RUDErdN23Q-EfPdhwqgUmSTSdvh4jTj" +
            "_18WowExON_QP0BDjLebzERplrOLFcCrHb8cjcCey35WcY9dLW9AZt_CXd-olD66hd9NTxGGuggQjR3j5BtnPDJ-vSjai" +
            "PGYR-n4J_0yQL9oYr2W-fdZmHgSLMiWJjtHP30nG1U41Igj7ZFZGcNd5NOfsWBjZ-jUrxTOAApotqNXx7VIcHMO14rWBH" +
            "wwjoTkWH0_vqhIFAL_XDc2QKlHILRK-BYs8kXSAOnUi1tmkhHDsjdGsZuJsNofL0eNaa2Iw%3D%3D&fp=jIjXJRf9fks5" +
            "5aAOPG3a3TaGOrh4alBf5K0n9lZgTGfe2V3Z4AUG-Pu_ngLCbjphqRwbi2-uKJmv8Sxck5Zs0_y3U9vIJoC0d46jl8wnLb6" +
            "9F3FZX-2bWKFhX8g_OTkHDTFJ1jigc94kHhG-jD7GQsIyKpc39Ur3F4qcGmr5HPRZSrFD0oA7JBBVhNeLrqTtZlqa8zz0jC-9ppMDwFGJlg%3D%3D"

    var ecd = ""
    var maskedPan = ""

    for (str in url.split("&")) {
        if (str.contains("ecd=")) {
            ecd = str.substring(str.lastIndexOf('=') + 1)
        } else if (str.contains("panmask=")) {
            maskedPan = str.substring(str.lastIndexOf('=') + 1)
        }
    }
    println(ecd)
    println(" ")
    println(maskedPan)*/

/*
//    println(getRandomAlphanumericString(5))

//    val a = 5.5
//    val b = 3.5

//    val time = Calendar.getInstance().time
//    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    val current = formatter.format(time)
//
//    val simpleDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    val currentDate = simpleDate.format(Date())
//
//    println(time)
//    println(currentDate)

//    val words = listOf("Cashback1", "Cashback2", "Cashback3")
//    val pattern = "Cashback1".toRegex()
//
//    words.forEach { word ->
//        if (pattern.containsMatchIn(word)) {
//            println("$word matches")
//        }
//    }

/*    val a = "Cashback14"
    val b = 1

    if ((a == "Cashback1" || a == "Cashback2" || a == "Cashback3") && b >= 1) {
        println("match")
    } else {
        println("no match")
    }*/

//    println(a == "Cashback1")

//    initPaddingStatusTxt()*/

    /*val b = "Cashback1"
    val c = "Cashback2"

    val a = "${b}\n\n${c}"
    println(a)*/

//    printType<String>()
//    printType<Int>()

//    val list: List<Any> = listOf("hello", 1, true)
//    val result: Boolean? = findFirst<Boolean>(list)
////    println(result)
//
//    val a = PositiveInt(10)
//    val b = PositiveInt(-5)

    println("Hello")
}

@JvmInline
value class PositiveInt(val value: Int) {
    init {
        require(value > 0) {
            "Value must be positive" // IllegalArgumentException
        }
    }
}

inline fun <reified T> printType() {
    println(T::class.simpleName)
}

inline fun <reified T> findFirst(list: List<Any>): T? {
    for (element in list) {
        if (element is T) {
            return element
        }
    }
    return null
}

private fun initPaddingStatusTxt() {
    val pending = "Test"
    var pending_d = "Text"

    pending_d = String.format(pending_d, 20)
    val start = pending_d.indexOf(pending)
    val end = pending_d.indexOf(pending) + pending.length
    val spannableString = SpannableString(pending_d)
    spannableString.setSpan(
        ForegroundColorSpan(Color.parseColor("#ffc45e")),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    println(spannableString.toString())
}

fun getRandomAlphanumericString(length: Int): String {
    val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}

//class Person {
//    var name: String = "defaultValue"
//        get() = field
//        set(value) {
//            field = value
//        }
//}

// Some comment
fun isNullOrZero(number: Number?): Boolean {
    return number == null ||
            when (number) {
                is Int -> number.toInt() == 0
                is Long -> number.toLong() == 0L
                is Double -> number.toDouble() == 0.0
                is Short -> number.toShort().toInt() == 0
                else -> number.toFloat() == 0f
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
