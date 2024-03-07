package com.example.kotlinbasics

import kotlin.math.exp
import kotlin.random.Random

class NeuralNetwork(private val inputSize: Int, private val hiddenSize: Int, private val outputSize: Int) {

    private val inputLayer: MutableList<Double> = MutableList(inputSize) { 0.0 }
    private val hiddenLayer: MutableList<Double> = MutableList(hiddenSize) { 0.0 }
    private val outputLayer: MutableList<Double> = MutableList(outputSize) { 0.0 }

    private val weightsInputToHidden: MutableList<MutableList<Double>> =
        MutableList(hiddenSize) { MutableList(inputSize) { Random.nextDouble(-1.0, 1.0) } }

    private val weightsHiddenToOutput: MutableList<MutableList<Double>> =
        MutableList(outputSize) { MutableList(hiddenSize) { Random.nextDouble(-1.0, 1.0) } }

    fun predict(input: List<Double>): List<Double> {
        require(input.size == inputSize) { "Input size does not match network input size." }
        inputLayer.indices.forEach { inputLayer[it] = input[it] }
        calculateHiddenLayer()
        calculateOutputLayer()
        return outputLayer.toList()
    }

    private fun calculateHiddenLayer() {
        for (i in hiddenLayer.indices) {
            hiddenLayer[i] = weightsInputToHidden[i].zip(inputLayer).sumOf { (w, x) -> w * x }.sigmoid()
        }
    }

    private fun calculateOutputLayer() {
        for (i in outputLayer.indices) {
            outputLayer[i] = weightsHiddenToOutput[i].zip(hiddenLayer).sumOf { (w, h) -> w * h }.sigmoid()
        }
    }

    fun train(input: List<Double>, target: List<Double>, learningRate: Double) {
        predict(input) // Forward propagation to calculate outputs

        // Backpropagation
        val outputErrors = MutableList(outputSize) { 0.0 }
        for (i in outputLayer.indices) {
            outputErrors[i] = target[i] - outputLayer[i]
        }

        val hiddenErrors = MutableList(hiddenSize) { 0.0 }
        for (i in hiddenLayer.indices) {
            hiddenErrors[i] = weightsHiddenToOutput.mapIndexed { j, _ -> outputErrors[j] * weightsHiddenToOutput[j][i] }.sum()
        }

        // Update weightsHiddenToOutput
        for (i in weightsHiddenToOutput.indices) {
            for (j in weightsHiddenToOutput[i].indices) {
                weightsHiddenToOutput[i][j] += learningRate * outputErrors[i] * hiddenLayer[j] * (1 - hiddenLayer[j]) // * derivative of sigmoid
            }
        }

        // Update weightsInputToHidden
        for (i in weightsInputToHidden.indices) {
            for (j in weightsInputToHidden[i].indices) {
                weightsInputToHidden[i][j] += learningRate * hiddenErrors[i] * inputLayer[j] * (1 - inputLayer[j]) // * derivative of sigmoid
            }
        }
    }

    private fun Double.sigmoid() = 1 / (1 + exp(-this))
}

fun main() {
    val inputSize = 2
    val hiddenSize = 3
    val outputSize = 1

    val neuralNetwork = NeuralNetwork(inputSize, hiddenSize, outputSize)

    val trainingData = listOf(
        Pair(listOf(0.0, 0.0), listOf(0.0)),
        Pair(listOf(0.0, 1.0), listOf(1.0)),
        Pair(listOf(1.0, 0.0), listOf(1.0)),
        Pair(listOf(1.0, 1.0), listOf(0.0))
    )

    repeat(10000) { // Training iterations
        for ((input, target) in trainingData) {
            neuralNetwork.train(input, target, 0.1)
        }
    }

    // Test the trained neural network
    for ((input, _) in trainingData) {
        val prediction = neuralNetwork.predict(input)
        println("Input: $input, Prediction: $prediction")
    }
}