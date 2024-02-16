package com.example.kotlinbasics

fun main() {
    val function: (Double) -> Double = { x -> x * x - 4 * x + 4 } // Example function
    val a = 0.0 // Lower bound of the interval
    val b = 4.0 // Upper bound of the interval
    val epsilon = 0.0001 // Tolerance for convergence

    val minimum = goldenSectionSearch(function, a, b, epsilon)
    println("Minimum value found at: $minimum with function value: ${function(minimum)}")
}

fun goldenSectionSearch(
    function: (Double) -> Double,
    a: Double,
    b: Double,
    epsilon: Double
): Double {
    val gr = (Math.sqrt(5.0) + 1) / 2 // Golden ratio

    var x1 = b - (b - a) / gr
    var x2 = a + (b - a) / gr
    var fx1 = function(x1)
    var fx2 = function(x2)

    var lowerBound = a
    var upperBound = b

    while (Math.abs(upperBound - lowerBound) > epsilon) {
        if (fx1 < fx2) {
            upperBound = x2
            x2 = x1
            fx2 = fx1
            x1 = upperBound - (upperBound - lowerBound) / gr
            fx1 = function(x1)
        } else {
            lowerBound = x1
            x1 = x2
            fx1 = fx2
            x2 = lowerBound + (upperBound - lowerBound) / gr
            fx2 = function(x2)
        }
    }

    return (lowerBound + upperBound) / 2
}