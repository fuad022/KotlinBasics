package com.example.kotlinbasics

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 1)
    )

    val result = maxAreaOfIsland(grid)
    println("Maximum Area of Island: $result")
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    var maxArea = 0

    fun dfs(row: Int, col: Int): Int {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0
        }

        grid[row][col] = 0 // Mark the cell as visited
        var area = 1

        // Explore neighbors
        area += dfs(row + 1, col)
        area += dfs(row - 1, col)
        area += dfs(row, col + 1)
        area += dfs(row, col - 1)

        return area
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 1) {
                val currentArea = dfs(i, j)
                maxArea = maxOf(maxArea, currentArea)
            }
        }
    }

    return maxArea
}