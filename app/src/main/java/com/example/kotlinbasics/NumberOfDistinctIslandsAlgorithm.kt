package com.example.kotlinbasics

import java.lang.StringBuilder

fun main() {
    val solution = SolutionNOD()
    val grid = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 1)
    )

    val result = solution.numDistinctIslands(grid)
    println("Number of distinct islands: $result")
}

class SolutionNOD {
    fun numDistinctIslands(grid: Array<IntArray>): Int {
        val seen = mutableListOf<String>()
        var result = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    val island = StringBuilder()
                    dfs(grid, i, j, island, "o") // "o" represents the origin
                    val islandStr = island.toString()
                    if (!seen.contains(islandStr)) {
                        seen.add(islandStr)
                        result++
                    }
                }
            }
        }

        return result
    }

    private fun dfs(
        grid: Array<IntArray>,
        i: Int,
        j: Int,
        island: StringBuilder,
        direction: String
    ) {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
            return
        }

        grid[i][j] = 0 // Mark the cell as visited

        island.append(direction)

        dfs(grid, i - 1, j, island, "u") // up
        dfs(grid, i + 1, j, island, "d") // down
        dfs(grid, i, j - 1, island, "l") // left
        dfs(grid, i, j + 1, island, "r") // right

        island.append("b") // "b" represents back, indicating the end of a direction
    }
}