package com.example.kotlinbasics

fun main() {
    val iArr = arrayOf(4, 65, 2, -31, 0, 99, 83, 782, 1)
    println(iArr.contentToString())
    patienceSort(iArr)
    println(iArr.contentToString())
}

/*
outer@ в данном коде представляет метку (label), которая помечает внешний цикл. Метки используются
в языке Kotlin для управления потоком выполнения вложенных циклов и блоков кода. В данном случае,
метка outer используется с оператором continue, чтобы указать, что нужно продолжить выполнение внешнего цикла, а не внутреннего.
Когда выполняется continue@outer, это означает, что выполнение цикла, помеченного меткой outer,
продолжится с начала следующей итерации внешнего цикла for (el in arr). Это позволяет пропустить
текущую итерацию внутреннего цикла for (pile in piles), и перейти к следующей итерации внешнего цикла for (el in arr).
В вашем конкретном коде, метка outer@ используется для управления вложенными циклами и контролирует
распределение элементов массива arr по "кучам" (piles) на основе их значений, сохраняя их в piles.
 */
fun patienceSort(arr: Array<Int>) {
    if (arr.size < 2) return
    val piles = mutableListOf<MutableList<Int>>()
    outer@ for (el in arr) {
        for (pile in piles) {
            if (pile.last() > el) {
                pile.add(el)
                continue@outer
            }
        }
        piles.add(mutableListOf(el))
    }

    for (i in 0 until arr.size) {
        var min = piles[0].last()
        var minPileIndex = 0
        for (j in 1 until piles.size) {
            if (piles[j].last() < min) {
                min = piles[j].last()
                minPileIndex = j
            }
        }
        arr[i] = min
        val minPile = piles[minPileIndex]
        minPile.removeAt(minPile.lastIndex)
        if (minPile.size == 0) piles.removeAt(minPileIndex)
    }
}