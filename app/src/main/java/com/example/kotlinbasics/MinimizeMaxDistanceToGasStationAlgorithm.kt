package com.example.kotlinbasics

fun main() {
    val stations = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val k = 9

    val result = minMaxDistanceToGasStation(stations, k)
    println("Minimum maximum distance to a gas station: $result")
}

fun minMaxDistanceToGasStation(stations: IntArray, k: Int): Double {
    var left = 0.0
    var right = 1e9

    while (right - left > 1e-6) {
        val mid = left + (right - left) / 2
        if (possible(stations, k, mid)) {
            right = mid
        } else {
            left = mid
        }
    }

    return left
}

fun possible(stations: IntArray, k: Int, distance: Double): Boolean {
    var usedStations = 0

    for (i in 0 until stations.size - 1) {
        val gap = stations[i + 1] - stations[i]
        usedStations += (gap / distance).toInt()

        if (usedStations > k) {
            return false
        }
    }

    return true
}