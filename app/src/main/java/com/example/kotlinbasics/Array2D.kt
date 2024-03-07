package com.example.kotlinbasics

fun main() {
    val rows = 3
    val cols = 4

    // Initializing a 2D array
    val array2D = Array(rows) { IntArray(cols) }

    // Filling the 2D array with some values
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            array2D[i][j] = i * cols + j
        }
    }

    // Printing the 2D array
    println("Original 2D Array:")
    printArray2D(array2D)

    // Accessing an element in th 2D array
    val element = array2D[1][2]
    println("Element at row 1, column 2: $element")

    // Modifying an element in the 2D array
    array2D[1][2] = 100

    // Printing the modified 2D array
    println("Modified 2D Array:")
    printArray2D(array2D)
}

fun printArray2D(array: Array<IntArray>) {
    for (row in array) {
        for (element in row) {
            print("$element\t")
        }
        println()
    }
}