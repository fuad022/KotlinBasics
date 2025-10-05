package com.example.kotlinbasics

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val rotations = 2

    println("Original array: ${array.contentToString()}")
    rotateArray(array, rotations)
    println("Array after $rotations right rotations: ${array.contentToString()}")
}

fun rotateArray(nums: IntArray, k: Int) {
    val rotations = k % nums.size // Adjust for multiple full array rotations

    reverseCCA(nums, 0, nums.size - 1)
    reverseCCA(nums, 0, rotations - 1)
    reverseCCA(nums, rotations, nums.size - 1)
}

fun reverseCCA(nums: IntArray, start: Int, end: Int) {
    var i = start
    var j = end
    while (i < j) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        i++
        j--
    }
}