package com.example.kotlinbasics

fun main() {

}

class SegmentTree(private val inputArray: IntArray) {
    private val segmentTree: IntArray

    init {
        val n = inputArray.size
        val height = (Math.log(n.toDouble()) / Math.log(2.0)).toInt() + 1
        val maxSize = 2 * Math.pow(2.0, height.toDouble()).toInt() - 1
        segmentTree = IntArray(maxSize)
        buildSegmentTree(0, 0, n - 1)
    }

    private fun buildSegmentTree(currentNode: Int, start: Int, end: Int) {
        if (start == end) {
            segmentTree[currentNode] = inputArray[start]
            return
        }

        val mid = start + (end - start) / 2
        buildSegmentTree(2 * currentNode + 1, start, mid)
        buildSegmentTree(2 * currentNode + 2, mid + 1, end)
        segmentTree[currentNode] =
            segmentTree[2 * currentNode + 1] + segmentTree[2 * currentNode + 2]
    }

//    fun query(left: Int, right: Int): Int {
//        return queryHelper(0, 0, inputArray.size - 1, left, right)
//    }
//
//    private fun queryHelper(currentNode: Int, start: Int, end: Int, left: Int, right: Int)
}