package com.example.kotlinbasics

import kotlin.random.Random

fun main() {
    val dungeonGame = DungeonGameDG(10, 10)
    dungeonGame.playGame()
}

class DungeonGameDG(val width: Int, val height: Int) {
    private val dungeonMap: Array<Array<Char>> = Array(height) { Array(width) { '.' } }
    private var playerX: Int = 0
    private var playerY: Int = 0

    init {
        generateDungeon()
        placePlayer()
    }

    private fun generateDungeon() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                dungeonMap[y][x] = if (Random.nextFloat() < 0.2) '#' else '.'
            }
        }
    }

    private fun placePlayer() {
        playerX = Random.nextInt(width)
        playerY = Random.nextInt(height)
        dungeonMap[playerY][playerX] = 'P'
    }

    private fun printDungeon() {
        for (row in dungeonMap) {
            for (cell in row) {
                print("$cell")
            }
            println()
        }
        println()
    }

    fun playGame() {
        printDungeon()

        // Main game loop
        while (true) {
            val input = readLine()

            when (input?.lowercase()) {
                "w" -> movePlayer(-1, 0)
                "a" -> movePlayer(0, -1)
                "s" -> movePlayer(1, 0)
                "d" -> movePlayer(0, 1)
                "q" -> {
                    println("Exiting the game. Goodbye!")
                    break
                }

                else -> println("Invalid input. Use WASD to move, or Q to quit.")
            }

            printDungeon()
        }
    }

    private fun movePlayer(deltaY: Int, deltaX: Int) {
        val newPlayerX = playerX + deltaX
        val newPlayerY = playerY + deltaY

        if (isValidMove(newPlayerY, newPlayerX)) {
            dungeonMap[playerY][playerX] = '.' // Clear the current position
            playerX = newPlayerX
            playerY = newPlayerY
            dungeonMap[playerY][playerX] = 'P' // Move the player to the new position
        } else {
            println("Invalid move. Try again.")
        }
    }

    private fun isValidMove(newY: Int, newX: Int): Boolean {
        return newY in 0 until height && newX in 0 until width && dungeonMap[newY][newX] != '#'
    }
}