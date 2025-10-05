package com.example.kotlinbasics

fun main() {
    // Создаем цепочку обработчиков
    val lowHandler = LowErrorHandler()
    val mediumHandler = MediumErrorHandler()
    val highHandler = HighErrorHandler()

    lowHandler.setNextHandler(mediumHandler).setNextHandler(highHandler)

    // Тестируем цепочку обработки ошибок
    lowHandler.handleRequest(3, "Низкий уровень ошибки")
    lowHandler.handleRequest(8, "Средний уровень ошибки")
    lowHandler.handleRequest(15, "Высокий уровень ошибки")
}

// Базовый класс для обработчиков ошибок
abstract class ErrorHandler {
    // Следующий обработчик в цепочке
    private var nextHandler: ErrorHandler? = null

    // Установка следующего обработчика
    fun setNextHandler(handler: ErrorHandler): ErrorHandler {
        nextHandler = handler
        return handler
    }

    // Обработка ошибки
    open fun handleRequest(errorLevel: Int, message: String) {
        if (canHandle(errorLevel)) {
            handle(errorLevel, message)
        } else {
            nextHandler?.handleRequest(errorLevel, message)
        }
    }

    // Проверка, может ли обработчик обработать ошибку данного уровня
    abstract fun canHandle(errorLevel: Int): Boolean

    // Обработка ошибки (каждый конкретный обработчик реализует этот метод по-своему)
    abstract fun handle(errorLevel: Int, message: String)
}

// Конкретный обработчик для низкого уровня ошибки
class LowErrorHandler : ErrorHandler() {
    override fun canHandle(errorLevel: Int): Boolean {
        return errorLevel <= 5
    }

    override fun handle(errorLevel: Int, message: String) {
        println("LowErrorHandler: Обработана ошибка уровня $errorLevel с сообщением: $message")
    }
}

// Конкретный обработчик для среднего уровня ошибки
class MediumErrorHandler : ErrorHandler() {
    override fun canHandle(errorLevel: Int): Boolean {
        return errorLevel <= 10
    }

    override fun handle(errorLevel: Int, message: String) {
        println("MediumErrorHandler: Обработана ошибка уровня $errorLevel с сообщением: $message")
    }
}

// Конкретный обработчик для высокого уровня ошибки
class HighErrorHandler : ErrorHandler() {
    override fun canHandle(errorLevel: Int): Boolean {
        return true // Высокий обработает все ошибки
    }

    override fun handle(errorLevel: Int, message: String) {
        println("HighErrorHandler: Обработана ошибка уровня $errorLevel с сообщением: $message")
    }
}