package com.example.kotlinbasics

fun main() {

//    println(getRepeatedIntersection(intArrayOf(1, 2, 3, 2, 0), intArrayOf(5, 1, 2, 7, 3, 2)))

//    println(minOf(5, 2))

//    val myArray = Array(5) { i -> i * i }
//    println(myArray.contentToString())

//    val myArrayDist = arrayOf("one", "two", "two", "three", "three", "four")
//    val uniqueArray = myArrayDist.distinct().toTypedArray()
//    println(uniqueArray.contentToString())
//
//    val myArrayToSet = arrayOf("one", "two", "two", "three", "four", "four")
//    val uniqueSet = myArrayToSet.toSet().toTypedArray()
//    println(uniqueSet.contentToString())
//
//    val myArrayForEach = arrayOf("one", "two", "two", "three", "three", "four")
//    val uniqueList = mutableListOf<String>()
//    for (element in myArrayForEach) {
//        if (!uniqueList.contains(element)) {
//            uniqueList.add(element)
//        }
//    }
//    val uniqueArrayForEach = uniqueList.toTypedArray()
//    println(uniqueArrayForEach.contentToString())

    /////
//    val numbers = listOf(1, 2, 3, 4, 5)
//    val sumReduce = numbers.reduce { acc, next -> acc + next }
//    println(sumReduce)
//
//    val numbersForFold = listOf(1, 2, 3, 4, 5)
//    val sumFold = numbersForFold.fold(0) { acc, next -> acc + next }
//    println(sumFold)
    ////

    println(panFormatted("xxxx1046"))
}

fun panFormatted(pan: String): String {
    if (pan.isEmpty().not() && pan.length > 4) {
        return "**** ${pan.substring(pan.length - 4)}"
    }
    return pan
}


fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {
    val s1 = a1.toHashSet()
    val s2 = a2.toHashSet()

    var result = mutableListOf<Int>()

    for (el in s1) {
        if (s2.contains(el)) {
            var a = a1.count { it == el }
            var b = a2.count { it == el }
            val numOfRepeats = minOf(a, b)
            repeat(numOfRepeats) {
                result.add(el)
            }
        }
    }

    return result
}


