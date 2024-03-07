package com.example.kotlinbasics

fun main() {
    val bitSet = BitSet(10)

    bitSet.set(1)
    bitSet.set(3)
    bitSet.set(5)

    println(bitSet) // Output: 0101010000

    println(bitSet.nextSetBit(0)) // Output: 1
    println(bitSet.nextSetBit(2)) // Output: 3
    println(bitSet.nextSetBit(4)) // Output: 5
    println(bitSet.nextSetBit(6)) // Output: -1
}

class BitSet(size: Int) {
    private val bits: MutableList<Boolean> = MutableList(size) { false }

    fun set(bitIndex: Int) {
        checkBounds(bitIndex)
        bits[bitIndex] = true
    }

    fun clear(bitIndex: Int) {
        checkBounds(bitIndex)
        bits[bitIndex] = false
    }

    fun get(bitIndex: Int): Boolean {
        checkBounds(bitIndex)
        return bits[bitIndex]
    }

    fun nextSetBit(fromIndex: Int): Int {
        var index = fromIndex
        while (index < bits.size) {
            if (bits[index]) {
                return index
            }
            index++
        }
        return -1
    }

    private fun checkBounds(bitIndex: Int) {
        require(bitIndex in 0 until bits.size) { "Index out of bounds" }
    }

    override fun toString(): String {
        return bits.joinToString(separator = "") { if (it) "1" else "0" }
    }
}