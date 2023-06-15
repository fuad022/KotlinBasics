package com.example.kotlinbasics

fun main() {
//    println(reverseString("Hello, World!"))
//    println(isPalindrome(""))
//    println(generateFibonacciSeries(50))
//    println(rotateArrayRight(arrayOf(1, 2, 3, 4, 5), 2))
//    println(twoSum(arrayOf(2, 7, 11, 15), 9))

//    val head = Node(3)
//    val node1 = Node(2)
//    val node2 = Node(0)
//    val node3 = Node(-4)
//
//    head.next = node1
//    node1.next = node2
//    node2.next = node3
//    node3.next = node1 //Creating a cycle
//
//    val hasCycle = hasCycle(head)
//    println(hasCycle)

//    println(binarySearch(arrayOf(2, 4, 6, 8, 10, 12, 14), 10))

    val array1 = arrayOf(1, 3, 5, 7)
    val array2 = arrayOf(2, 4, 6, 8)
    val mergedArray = mergeSortedArrays(array1, array2)
    println(mergedArray.joinToString())
}

/*
Reverse a String: Write a algorithm function to reverse a given string in Kotlin.
 */
fun reverseString(input: String): String {
    val charArray = input.toCharArray()
    var start = 0
    var end = input.length - 1

    while (start < end) {
        val temp = charArray[start]
        charArray[start] = charArray[end]
        charArray[end] = temp

        start++
        end--
    }

    return String(charArray)
//    return StringBuilder().append(charArray).toString()
}

/*
Palindrome Check: Write a function to check
if a given string is a palindrome (reads the same forwards and backwards).
 */
fun isPalindrome(input: String): Boolean {
    var start = 0
    var end = input.length - 1

    while (start < end) {
        if (input[start].lowercase() != input[end].lowercase()) {
            return false
        }
        start++
        end--
    }

    return true
}

/*
Fibonacci Series: Write an algorithm function to generate the Fibonacci series up to a given number.
 */
fun generateFibonacciSeries(limit: Int): List<Int> {
    val series = mutableListOf<Int>()

    var prev = 0
    var current = 1

    while (prev <= limit) {
        series.add(prev)

        val next = prev + current
        prev = current
        current = next
    }

    return series
}

/*
Array Rotation: Given an array, write an algorithm function
to rotate the array elements to the right by a given number of steps.
 */
fun rotateArrayRight(array: Array<Int>, steps: Int): String {
    val rotateArray = IntArray(array.size)

    for (i in array.indices) {
        val newIndex = (i + steps) % array.size
        rotateArray[newIndex] = array[i]
    }

    return rotateArray.joinToString()
}

/*
Two Sum: Given an array of integers and a target number,
write an algorithm function to find two numbers in the array that add up to the target.
 */
fun twoSum(array: Array<Int>, target: Int): String {
    var twoSumArray = emptyArray<Int>()

    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] + array[j] == target) {
                twoSumArray = arrayOf(array[i], array[j])
            }
        }
    }

    return twoSumArray.joinToString()
}

/*
Linked List Cycle: Given a linked list, write an algorithm function to determine
if the list contains a cycle
(i.e., there is a node that can be reached again by continuously following the next pointer).
 */
class Node(var value: Int) {
    var next: Node? = null
}

fun hasCycle(head: Node?): Boolean {
    var slow = head
    var fast = head

    //3, 2, 0, -4
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }

    return false
}

/*
Binary Search: Write an algorithm function to perform a binary search
on a sorted array and return the index of the target element if it exists, or -1 if it does not.
 */
fun binarySearch(array: Array<Int>, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            array[mid] == target -> {
                return mid
            }

            array[mid] < target -> {
                left = mid + 1
            }

            else -> {
                right = mid - 1
            }
        }
    }

    return -1
}

/*
Merge Sorted Arrays: Given two sorted arrays,
write a function to merge them into a single sorted array.
 */
fun mergeSortedArrays(array1: Array<Int>, array2: Array<Int>): Array<Int> {
    val mergedArray = IntArray(array1.size + array2.size)

    var index1 = 0
    var index2 = 0
    var mergeIndex = 0

    while (index1 < array1.size && index2 < array2.size) {
        if (array1[index1] <= array2[index2]) {
            mergedArray[mergeIndex] = array1[index1]
            index1++
        } else {
            mergedArray[mergeIndex] = array2[index2]
            index2++
        }
        mergeIndex++
    }

    while (index1 < array1.size) {
        mergedArray[mergeIndex] = array1[index1]
        index1++
        mergeIndex++
    }

    while (index2 < array2.size) {
        mergedArray[mergeIndex] = array2[index2]
        index2++
        mergeIndex++
    }

    return mergedArray.toTypedArray()
}