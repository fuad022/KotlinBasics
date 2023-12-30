package com.example.kotlinbasics

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

fun main() {
    // Генерация пары ключей
    val keyPair: KeyPair = generateKeyPair()

    // Исходное сообщение
    val originalMessage = "Hello, RSA!"

    // Шифрование сообщения
    val encryptedMessage = encrypt(originalMessage, keyPair.public)

    // Расшифрование сообщения
    val decryptedMessage = decrypt(encryptedMessage, keyPair.private)

    println("Original Message: $originalMessage")
    println("Encrypted Message: $encryptedMessage")
    println("Decrypted Message: $decryptedMessage")
}

fun generateKeyPair(): KeyPair {
    val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyPairGenerator.initialize(2048) // Размер ключей - 2048 бит
    return keyPairGenerator.generateKeyPair()
}

fun encrypt(message: String, publicKey: PublicKey): ByteArray {
    val cipher = Cipher.getInstance("RSA")
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    return cipher.doFinal(message.toByteArray())
}

fun decrypt(encryptedMessage: ByteArray, privateKey: PrivateKey): String {
    val cipher = Cipher.getInstance("RSA")
    cipher.init(Cipher.DECRYPT_MODE, privateKey)
    val decryptedBytes = cipher.doFinal(encryptedMessage)
    return String(decryptedBytes)
}