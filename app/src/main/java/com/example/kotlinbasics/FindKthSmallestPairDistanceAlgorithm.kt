package com.example.kotlinbasics

fun main() {
    val nums = intArrayOf(1, 3, 1)
    val k = 1
    val result = kthSmallestDistance(nums, k)
    println("The $k-th smallest pair distance is: $result")
}

fun kthSmallestDistance(nums: IntArray, k: Int): Int {
    val sortedNums = nums.sorted()
    var low = 0
    var high = sortedNums[sortedNums.size - 1] - sortedNums[0]

    while (low < high) {
        val mid = (low + high) / 2
        if (countPairs(sortedNums, mid) < k) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}

fun countPairs(nums: List<Int>, target: Int): Int {
    var count = 0
    var left = 0

    for (right in 0 until nums.size) {
        while (nums[right] - nums[left] > target) {
            left++
        }
        count += right - left
    }

    return count
}