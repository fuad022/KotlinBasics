package com.example.kotlinbasics

import java.security.MessageDigest
import kotlin.random.Random

fun main() {
    // Parameters
    val dataSize = 1024 // Size of random data in bytes
    val space = 32 // Proof space size in bytes
    val time = 100 // Iterations

    // Generate random data
    val data = generateRandomData(dataSize)

    // Compute proof of space
    val proof = proofOfSpace(data, space, time)

    // Output proof of space
    println("Proof of Space: ${proof.joinToString("") { "%02x".format(it) }}")
}

// Function to generate random data of specified length
fun generateRandomData(length: Int): ByteArray {
    val random = Random.Default
    val data = ByteArray(length)
    random.nextBytes(data)
    return data
}

// Function to compute hash of data
fun computeHash(data: ByteArray): ByteArray {
    val digest = MessageDigest.getInstance("SHA-256")
    return digest.digest(data)
}

// Proof of Space algorithm
fun proofOfSpace(data: ByteArray, space: Int, time: Int): ByteArray {
    var currentData = data
    repeat(time) {
        currentData = computeHash(currentData)
    }
    val proofSpace = currentData.slice(0 until space).toByteArray()
    return proofSpace
}