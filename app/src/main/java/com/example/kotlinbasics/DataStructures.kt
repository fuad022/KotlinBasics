package com.example.kotlinbasics

import java.security.MessageDigest
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.Stack

fun main() {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* /*
     Given an array arr[] of size n, write a program to find the maximum and minimum element present in the array.
      */
 //    val arr = arrayOf(4, 2, 0, 8, 20, 9, 2)
 //    var largest = arr[0]
 //    var smallest = arr[0]
 //
 //    for (num in arr) {
 //        if (largest < num)
 //            largest = num
 //        if (smallest > num)
 //            smallest = num
 //    }
 //    println("Largest: $largest and smallest: $smallest")*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* /*
     Given an array arr[] of size n, write a program to reverse the array.
      */
 //    val arr = arrayOf(4, 5, 1, 2)
 //    println(reverse(arr))*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* /*
     Recursion Factorial
      */
 //    countdown(10)
 //    println(factorial(4))*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*/*
    Fibonacci
     */
    println(fibonacci(3))*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    example6()
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*push(1)
    push(2)
    push(3)

    println(peek()) // Выведет 3

    println(pop()) // Выведет 3
    println(pop()) // Выведет 2

    println(isEmpty()) // Выведет false
    println(size()) // Выведет 1*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    example14()
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*// Пример использования
    val inputString = "Hello, world!"
    val sha256Hash = generateSHA256Hash(inputString)
    println(sha256Hash)*/
    //////////////////////////////////////  Priority Queue  //////////////////////////////////////////////////////////
//    example15()
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    example16()
}

fun reverse(list: Array<Int>): List<Int> {
    val result = arrayListOf<Int>()
    for (i in list.indices) { // list.indices == (0..list.size - 1)
        val number = list[list.size - 1 - i]
        result.add(number)
    }
    return result
}

fun countdown(n: Int) {
    if (n < 1) { // Base Case
        return
    }
    println(n)
    countdown(n - 1) // Recursive
}

fun factorial(n: Long): Long {
    if (n == 0L) { // Base Case
        return 1
    }
    return n * factorial(n - 1) // Recursive Structure
}

fun fibonacci(n: Long): Long {
    if (n <= 1) return n // Base Case
    return fibonacci(n - 1) + fibonacci(n - 2) // Recursive Structure
}

//////////////////////////////////////  Array and LinkedList   /////////////////////////////////////////////////
//Массив(Array) - это упорядоченная коллекция элементов, которые хранятся в памяти последовательно.
//В чем разница между массивом и связным списком?

//Пример массива(Array)
//Создание массива целых чисел
val array = arrayOf(1, 2, 3, 4, 5)

//Доступ к элементу массива по индексу
val element = array[2] // Получит значение 3

//Изменение значения элемента массива
fun example1() {
    array[1] = 10
}

//Перебор элементов массива
fun example2() {
    for (element in array) {
        println(element)
    }
}

//Связный список(LinkedList) - это структура данных, состоящая из узлов, где каждый узел содержит значение и ссылку на следующий узел.
//Пример связного списка (LinkedList):
//Определение класса узла связного списка
class NodeExample(var data: Int) {
    var next: NodeExample? = null
}

//Создание связного списка
val head = NodeExample(1)
val second = NodeExample(2)
val third = NodeExample(3)

//Установка связей между узлами
fun example3() {
    head.next = second
    second.next = third
}

//Доступ к элементам связного списка последовательно
fun example4() {
    var currentNode: NodeExample? = head
    while (currentNode != null) {
        println(currentNode.data)
        currentNode = currentNode.next
    }
}

//Вставка нового узла после заданного узла
fun example5() {
    /*val head = NodeExample(1)
    val second = NodeExample(2)
    val third = NodeExample(3)

    head.next = second
    second.next = third*/

    val newNode = NodeExample(4)
    val nodeToInsertAfter = second
    newNode.next = nodeToInsertAfter.next
    nodeToInsertAfter.next = newNode

    /* var currentNode: NodeExample? = head
     while (currentNode != null) {
         println(currentNode.data)
         currentNode = currentNode.next
     }*/
}

//Удаление узла из связного списка
fun example6() {
    /*val head = NodeExample(1)
    val second = NodeExample(2)
    val third = NodeExample(3)

    head.next = second
    second.next = third*/

    val nodeToDelete = second
    nodeToDelete.next = nodeToDelete.next?.next

    /*var currentNode: NodeExample? = head
    while (currentNode != null) {
        println(currentNode.data)
        currentNode = currentNode.next
    }*/
}


//////////////////////////////////////  Stack   ////////////////////////////////////////////////////////////////
//Объясните концепцию стека и его реализацию на языке Kotlin.

private val stackArray = mutableListOf<Int>()

//Помещение элемента в стек
fun push(element: Int) {
    stackArray.add(element)
}

//Извлечение и удаление верхнего элемента из стека
fun pop(): Int? {
    if (isEmpty()) {
        return null
    }
    return stackArray.removeAt(stackArray.size - 1)
}

//Просмотр верхнего элемента стека без удаления
fun peek(): Int? {
    if (isEmpty()) {
        return null
    }
    return stackArray[stackArray.size - 1]
}

//Проверка, пуст ли стек
fun isEmpty(): Boolean {
    return stackArray.isEmpty()
}

//Получение размера стека
fun size(): Int {
    return stackArray.size
}

//////////////////////////////////////  Queue   ////////////////////////////////////////////////////////////////
//Создание очереди
val queue: Queue<String> = LinkedList()

//Добавление элементов в очередь
fun example8() {
    queue.add("Message 1")
    queue.add("Message 2")
    queue.add("Message 3")
}

//Получение значения первого элемента без его удаления
fun example9() {
    val firstMessage = queue.peek()
    println(firstMessage) // Выведет "Message 1"
}

//Удаление первого элемента из очереди
fun example10() {
    val removedMessage = queue.poll()
    println(removedMessage) // Выведет "Message 1"
}

//Обход и обработка всех элементов в очереди
fun example11() {
    while (!queue.isEmpty()) {
        val message = queue.poll()
        //Обработка сообщения, например, отправка уведомления
        println("Отправка сообщения: $message")
    }
}

//Проверка, пуста ли очередь
fun example12() {
    val isEmpty = queue.isEmpty()
    println(isEmpty) // Выведет true
}

//////////////////////////////////////  Binary Tree and  Binary Search Tree  ////////////////////////////////////////////////////////////////
//Определение класса узла бинарного дерева
class BinaryTreeNode(val value: Int) {
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null
}

//Создание бинарного дерева
fun example13() {
    val rootNode = BinaryTreeNode(1)
    val leftChild = BinaryTreeNode(2)
    val rightChild = BinaryTreeNode(3)

    rootNode.left = leftChild
    rootNode.right = rightChild
}


//Определение класса узла бинарного дерева поиска
class BinarySearchTreeNode(val value: Int) {
    var left: BinarySearchTreeNode? = null
    var right: BinarySearchTreeNode? = null
}

//Вставка нового значения в бинарное дерево поиска
fun insertNode(root: BinarySearchTreeNode?, value: Int): BinarySearchTreeNode {
    if (root == null) {
        return BinarySearchTreeNode(value)
    }

    if (value < root.value) {
        root.left = insertNode(root.left, value)
    } else if (value > root.value) {
        root.right = insertNode(root.right, value)
    }

    return root
}

//Пример использования
fun example14() {
    val bstRootNode = BinarySearchTreeNode(4)
    insertNode(bstRootNode, 2)
    insertNode(bstRootNode, 6)
    insertNode(bstRootNode, 1)
    insertNode(bstRootNode, 3)
    insertNode(bstRootNode, 5)
    insertNode(bstRootNode, 7)

    //Распечатка бинарного дерева поиска***
    printBinarySearchTree(bstRootNode)
}

//Распечатка бинарного дерева поиска***
fun printBinarySearchTree(root: BinarySearchTreeNode?) {
    if (root != null) {
        printBinarySearchTree(root.left)
        print("${root.value} ")
        printBinarySearchTree(root.right)
    }
}

//////////////////////////////////////  Hashing  ////////////////////////////////////////////////////////////////
// Функция для генерации хеш-кода строки с использованием SHA-256
fun generateSHA256Hash(input: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val encodedHash = digest.digest(input.toByteArray())

    // Преобразование байтового массива в строку
    val stringBuilder = StringBuilder()
    for (byte in encodedHash) {
        stringBuilder.append(String.format("%02x", byte))
    }
    return stringBuilder.toString()
}

//////////////////////////////////////  Priority Queue  ////////////////////////////////////////////////////////////////
// Класс для элемента в приоритетной очереди
data class PriorityQueueItem(val value: Int, val priority: Int)

fun example15() {
    // Создание приоритетной очереди
    val priorityQueue = PriorityQueue<PriorityQueueItem> { item1, item2 ->
        item2.priority - item1.priority // Сравнение элементов по приоритету в обратном порядке
    }

    // Добавление элементов с приоритетом
    priorityQueue.add(PriorityQueueItem(1, 5))
    priorityQueue.add(PriorityQueueItem(2, 3))
    priorityQueue.add(PriorityQueueItem(3, 8))
    priorityQueue.add(PriorityQueueItem(4, 1))

    // Извлечение элементов с наивысшим приоритетом
    while (priorityQueue.isNotEmpty()) {
        val item = priorityQueue.poll()
        println("Value: ${item.value}, Priority: ${item.priority}")
    }
}

//////////////////////////////////////  Tree  ////////////////////////////////////////////////////////////////
//AVL tree
// Определение класса узла дерева
class AVLNode<T>(val value: T) {
    var left: AVLNode<T>? = null
    var right: AVLNode<T>? = null
    var height: Int = 1
}

// Определение класса АВЛ-дерева
class AVLTree<T : Comparable<T>> {
    var root: AVLNode<T>? = null

    // Вычисление высоты узла
    private fun height(node: AVLNode<T>?): Int {
        return node?.height ?: 0
    }

    // Вычисление баланса узла
    private fun getBalance(node: AVLNode<T>?): Int {
        return height(node?.left) - height(node?.right)
    }

    // Выполнение поворота влево
    private fun rotateLeft(z: AVLNode<T>): AVLNode<T> {
        val y = z.right
        val T2 = y?.left

        y?.left = z
        z.right = T2

        z.height = maxOf(height(z.left), height(z.right)) + 1
        y?.height = maxOf(height(y?.left), height(y?.right)) + 1

        return y ?: z
    }

    // Выполнение поворота вправо
    private fun rotateRight(z: AVLNode<T>): AVLNode<T> {
        val y = z.left
        val T3 = y?.right

        y?.right = z
        z.left = T3

        z.height = maxOf(height(z.left), height(z.right)) + 1
        y?.height = maxOf(height(y?.left), height(y?.right)) + 1

        return y ?: z
    }

    // Вставка узла в дерево
    fun insert(value: T) {
        root = insertNode(root, value)
    }

    private fun insertNode(node: AVLNode<T>?, value: T): AVLNode<T> {
        if (node == null) {
            return AVLNode(value)
        }

        if (value < node.value) {
            node.left = insertNode(node.left, value)
        } else if (value > node.value) {
            node.right = insertNode(node.right, value)
        } else {
            return node // Дубликаты не допускаются
        }

        node.height = 1 + maxOf(height(node.left), height(node.right))

        val balance = getBalance(node)

        // Проверка нарушения баланса
        if (balance > 1 && value < node.left!!.value) {
            return rotateRight(node)
        }

        if (balance < -1 && value > node.right!!.value) {
            return rotateLeft(node)
        }

        if (balance > 1 && value > node.left!!.value) {
            node.left = rotateLeft(node.left!!)
            return rotateRight(node)
        }

        if (balance < -1 && value < node.right!!.value) {
            node.right = rotateRight(node.right!!)
            return rotateLeft(node)
        }

        return node
    }

    // Поиск элемента в дереве
    fun search(value: T): Boolean {
        return searchNode(root, value)
    }

    private fun searchNode(node: AVLNode<T>?, value: T): Boolean {
        if (node == null) {
            return false
        }

        if (value == node.value) {
            return true
        } else if (value < node.value) {
            return searchNode(node.left, value)
        } else {
            return searchNode(node.right, value)
        }
    }
}

fun example16() {
    val tree = AVLTree<Int>()

    // Вставка элементов
    tree.insert(10)
    tree.insert(20)
    tree.insert(30)
    tree.insert(40)
    tree.insert(50)

    // Поиск элемента
    val found = tree.search(50)
    if (found) {
        println("Element found")
    } else {
        println("Element not found")
    }
}

//////////////////////////////////////  Graph  ////////////////////////////////////////////////////////////////
fun example17() {

}