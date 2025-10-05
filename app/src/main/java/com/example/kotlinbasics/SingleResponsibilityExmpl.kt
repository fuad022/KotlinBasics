package com.example.kotlinbasics

fun main() {
    /*
    Принцип единственной ответственности (Single Responsibility Principle, SRP)
    является одним из пяти принципов SOLID, который определяет, что класс должен
    иметь только одну причину для изменения. Он гласит, что каждый класс должен
    быть ответственным только за одну важную функциональность.
     */
}

// Класс, отвечающий за хранение информации о клиенте
class CustomerSRP(val name: String, val email: String) {
    fun getCustomerDetails(): String {
        return "Name: $name, Email: $email"
    }
}

// Класс, отвечающий за вычисление скидки для клиента
class DiscountCalculatorSRP {
    fun calculatorDiscount(orderTotal: Double): Double {
        if (orderTotal > 100.0) {
            return orderTotal * 0.1
        }
        return 0.0
    }
}