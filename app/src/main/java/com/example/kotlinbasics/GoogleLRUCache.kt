package com.example.kotlinbasics

class LRUCache<K, V>(private val capacity: Int) : LinkedHashMap<K, V>(capacity, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return size > capacity
    }
}

fun main() {
    val lruCache = LRUCache<Int, String>(3)

    lruCache[1] = "One"
    lruCache[2] = "Two"
    lruCache[3] = "Three"

    println(lruCache) // Output: {1=One, 2=Two, 3=Three}

    lruCache[4] = "Four"

    println(lruCache) // Output: {2=Two, 3=Three, 4=Four}

    println(lruCache[2]) // Output: Two

    println(lruCache) // Output: {3=Three, 4=Four, 2=Two}
}

