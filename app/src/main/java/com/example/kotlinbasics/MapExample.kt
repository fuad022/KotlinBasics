package com.example.kotlinbasics

fun main() {

//    val countries: Map<String, Int> = mapOf("USA" to 300, "France" to 60, "Germany" to 81)

//    println(countries["USA"])

    val countries: MutableMap<String, Int> = mutableMapOf("USA" to 300, "France" to 60, "Germany" to 81)

    countries.put("Spain", 33)
    countries.remove("France")

    for (country in countries) {
        println("${country.key} - ${country.value}")
    }
    println(countries)

    val map1: LinkedHashMap<Int, String> = linkedMapOf(1 to "1", 2 to "2")
    val map2: HashMap<Int, String> = hashMapOf(1 to "1", 2 to "2")

}
