package com.example.kotlinbasics

fun main() {
    val image1: Image = ProxyImage("image1.jpg")
    val image2: Image = ProxyImage("image2.jpg")

    // Изображение загружается только при вызове display()
    image1.display()

    // Изображение уже загружено, оно будет отображено сразу
    image1.display()

    // Изображение 2 загружается только при вызове display()
    image2.display()
}

// Интерфейс для изображения
interface Image {
    fun display()
}

// Реальное изображение
class RealImage(private val filename: String) : Image {
    init {
        loadFromDisk()
    }

    private fun loadFromDisk() {
        println("Loading image: $filename")
    }

    override fun display() {
        println("Displaying image: $filename")
    }
}

// Заместитель изображения
class ProxyImage(private val filename: String) : Image {
    private var realImage: RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(filename)
        }
        realImage?.display()
    }
}