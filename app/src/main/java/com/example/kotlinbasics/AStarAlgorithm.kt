package com.example.kotlinbasics

import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    val start = NodeAStar(0, 0)
    val goal = NodeAStar(4, 4)

    val path = aStar(start, goal, grid)

    if (path.isNotEmpty()) {
        println("Path found:")
        for (node in path) {
            println("(${node.x}, ${node.y})")
        }
    } else {
        println("No path found")
    }
}

data class NodeAStar(
    val x: Int,
    val y: Int,
    var g: Int = Int.MAX_VALUE,
    var h: Int = 0,
    var parent: NodeAStar? = null
) : Comparable<NodeAStar> {
    override fun compareTo(other: NodeAStar): Int {
        return (g + h) - (other.g + other.h)
    }
}

fun aStar(start: NodeAStar, goal: NodeAStar, grid: Array<IntArray>): List<NodeAStar> {
    val openSet = PriorityQueue<NodeAStar>()
    val closedSet = mutableSetOf<NodeAStar>()

    openSet.add(start)

    while (openSet.isNotEmpty()) {
        val current = openSet.poll()

        if (current == goal) {
            return reconstructPath(current)
        }

        closedSet.add(current)

        for (neighbor in getNeighbors(current, grid)) {
            if (neighbor in closedSet) {
                continue
            }

            val tentativeGScore = current.g + getDistance(current, neighbor)

            if (tentativeGScore < neighbor.g) {
                neighbor.parent = current
            }
        }
    }

    return emptyList()
}

fun getNeighbors(node: NodeAStar, grid: Array<IntArray>): List<NodeAStar> {
    val neighbors = mutableListOf<NodeAStar>()

    for (dx in -1..1) {
        for (dy in -1..1) {
            if (dx == 0 && dy == 0) {
                continue
            }

            val newX = node.x + dx
            val newY = node.y + dy

            if (isValidLocation(newX, newY, grid)) {
                neighbors.add(NodeAStar(newX, newY))
            }
        }
    }

    return neighbors
}

fun isValidLocation(x: Int, y: Int, grid: Array<IntArray>): Boolean {
    return x in grid.indices && y in grid[x].indices && grid[x][y] == 0
}

fun getDistance(nodeA: NodeAStar, nodeB: NodeAStar): Int {
    val dx = abs(nodeA.x - nodeB.x)
    val dy = abs(nodeA.y - nodeB.y)
    return dx + dy
}

fun reconstructPath(node: NodeAStar): List<NodeAStar> {
    val path = mutableListOf<NodeAStar>()
    var current: NodeAStar? = node

    while (current != null) {
        path.add(current)
        current = current.parent
    }

    return path.reversed()
}