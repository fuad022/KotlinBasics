package com.example.kotlinbasics

fun main() {
    // Создаем менеджер состояния и исходное состояние игры
    val stateManager = GameStateManager(GameState(level = 1, score = 0))

    // Сохраняем текущее состояние игры
    val memento = stateManager.saveState()

    // Изменяем состояние игры
    stateManager.state = GameState(level = 2, score = 100)

    // Печатаем текущее состояние игры
    println("Current State: ${stateManager.state}")

    // Восстанавливаем состояние из снимка
    stateManager.restoreState(memento)

    // Печатаем восстановленное состояние игры
    println("Restored State: ${stateManager.state}")
}

// Создаем класс, который представляет наше состояние
data class GameState(val level: Int, val score: Int)

// Создаем класс, который будет содержать снимок состояния
class GameStateMemento(val state: GameState)

// Создаем класс, который будет отвечать за управление состоянием
class GameStateManager(var state: GameState) {
    // Функция для сохранения состояния в снимке
    fun saveState(): GameStateMemento {
        return GameStateMemento(state)
    }

    // Функция для восстановления состояния из снимка
    fun restoreState(memento: GameStateMemento) {
        state = memento.state
    }
}