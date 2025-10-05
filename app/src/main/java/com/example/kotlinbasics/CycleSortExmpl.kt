package com.example.kotlinbasics

fun main() {
    val array = arrayOf(0, 1, 2, 2, 2, 2, 5, 8, 4, 7, 0, 6)
    println("Before sorting : ")
    for (a in array) print("$a  ")

    cycleSort(array)
    println("After sorting : ")
    for (a in array) print("$a  ")
}

fun cycleSort(array: Array<Int>): Int {
    var writes = 0

    // Loop through the array to find cycles to rotate.
    for (cycleStart in 0 until array.size - 1) {
        var item = array[cycleStart]

        // Find where to put the item.
        var pos = cycleStart
        for (i in cycleStart + 1 until array.size) {
            if (array[i] < item) {
                pos++
            }
        }

        // If the item is already there, this is not a cycle.
        if (pos == cycleStart) continue

        // Otherwise, put the item there or right after any duplicates.
        while (item == array[pos]) {
            pos++
        }
        val temp = array[pos]
        array[pos] = item
        item = temp
        writes++

        // Rotate the rest of the cycle.
        while (pos != cycleStart) {
            // Find where to put the item.
            pos = cycleStart
            for (i in cycleStart + 1 until array.size) {
                if (array[i] < item) pos++
            }

            // Otherwise, put the item there or right after any duplicates.
            while (item == array[pos]) {
                pos++
            }
            val temp2 = array[pos]
            array[pos] = item
            item = temp2
            writes++
        }
    }
    return writes
}