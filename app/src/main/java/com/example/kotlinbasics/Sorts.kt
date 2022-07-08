package com.example.kotlinbasics

fun main() {
//    val list = bubbleSort(intArrayOf(2, 15, 1, 8, 4))
//    val list = selectionSort(intArrayOf(2, 15, 1, 8, 4))
//    val list = insertionSort(intArrayOf(2, 15, 1, 8, 4, 56, 454, 6, 44))
//    for (k in list) print("$k ")

//    val numbers = mutableListOf(38, 27, 43, 3, 9, 82, 10)
//    val sortedList = mergeSort(numbers)
//    println("$sortedList")

    val numbers = listOf(2, 4, 7, 3, 6)
    val ordered = quickSort(numbers)
    println(ordered)
}

fun bubbleSort(arr: IntArray): IntArray {
    var swap = true
    while (swap) {
        swap = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

fun selectionSort(arr: IntArray): IntArray {
    for (i in 0..arr.size - 1) {
        var indexOfMin = i
        for (j in arr.size - 1 downTo i) {
            if (arr[j] < arr[indexOfMin])
                indexOfMin = j
        }
        if (i != indexOfMin) {
            val temp = arr[i]
            arr[i] = arr[indexOfMin]
            arr[indexOfMin] = temp
        }
    }
    return arr
}

fun insertionSort(arr: IntArray): IntArray {
    if (arr.isEmpty() || arr.size < 2) {
        return arr
    }
    for (count in 0..arr.size - 1) {
        val item = arr[count]
        var i = count
        while (i > 0 && item < arr[i - 1]) {
            arr[i] = arr[i - 1]
            i -= 1
        }
        arr[i] = item
    }
    return arr
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    val newList = mutableListOf<Int>()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }

    return newList
}

fun quickSort(items: List<Int>): List<Int> {
//    val size = items.size
//    val count = items.count()
//    println("size " + size)
//    println("count " + count)

    if (items.size < 2) return items

    val pivot = items[items.size / 2]

    val equal = items.filter {
        it == pivot
    }

    val less = items.filter {
        it < pivot
    }

    val greater = items.filter {
        it > pivot
    }

    return quickSort(less) + equal + quickSort(greater)
}