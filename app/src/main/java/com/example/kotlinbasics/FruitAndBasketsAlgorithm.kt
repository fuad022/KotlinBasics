package com.example.kotlinbasics

/*
Let’s assume 1 = apple🍎, 2 = banana🍌, 3 = pineapple🍍, so you can easily imagine and understand the scenario better.
The whole process will be like this:
🔧Step 1. We take a type 1 fruit. Currently, we have an apple in our basket: [ 🍎]
🔧Step 2. We take a type 2 fruit. Currently, we have an apple and a banana in our basket: [ 🍎, 🍌]
🔧Step 3. We take a type 2 fruit. Currently, we have an apple and two banana in our basket: [ 🍎, 🍌, 🍌]
🔧Step 4. We take a type 3 fruit. However, currently, our basket already has 2 different types of fruits.
We decide to abandon the apple so that we can add one type 3 fruit into our basket.
Currently, we have two banana and a pineapple: [ 🍌, 🍌, 🍍]
🔧Step 5. We take a type 2 fruit. Currently, we have three banana and one pineapple in our basket: [ 🍌, 🍌, 🍍, 🍌]
🔧Step 6. We take a type 2 fruit. Currently, we have four banana and one pineapple in our basket: [ 🍌, 🍌,🍍, 🍌, 🍌]
🚧Hence, we will get at most 5 fruits on our hands in the whole process.
 */

fun main() {
    val tree1 = intArrayOf(1, 2, 1)
    val tree2 = intArrayOf(1, 2, 2, 3, 2, 2)
    val result1 = totalFruit(tree1)
    val result2 = totalFruit(tree2)
    println("Result1 : $result1")
    println("Result2 : $result2")
}

fun totalFruit(tree: IntArray): Int {
    val n = tree.size
    var type1 = tree[0]
    var type2 = -1
    var combos = 1 // assume type1 is prev type
    var curLen = 1
    var max = 1

    for (i in 1 until n) {
        if (tree[i] != type1 && tree[i] != type2 && type2 != -1) {
            max = maxOf(curLen, max)
            curLen = combos + 1
            type2 = type1
            type1 = tree[i]
            combos = 1
            continue
        }
        if (tree[i] == type1) {
            combos++
        } else { // swap type1 and type2
            type2 = type1
            type1 = tree[i]
            combos = 1
        }
        curLen++
    }

    return maxOf(max, curLen)
}