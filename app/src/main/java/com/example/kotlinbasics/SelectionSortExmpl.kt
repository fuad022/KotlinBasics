package com.example.kotlinbasics

fun main() {
    println("Before Sort")
    val A = intArrayOf(1, 7, 3, 9, 4)
    for (i in A) print(i)

    selectionSortSS(A)

    println("Sorted array is : ")
    for (i in A) print(i)
}

fun selectionSortSS(sampleArray: IntArray) {
    val n = sampleArray.size
    var temp: Int
    for (i in 0..n - 1) {
        var indexOfMin = i
        for (j in n - 1 downTo i) {
            if (sampleArray[j] < sampleArray[indexOfMin]) {
                indexOfMin = j
            }
        }
        if (i != indexOfMin) {
            temp = sampleArray[i]
            sampleArray[i] = sampleArray[indexOfMin]
            sampleArray[indexOfMin] = temp
        }
    }
}