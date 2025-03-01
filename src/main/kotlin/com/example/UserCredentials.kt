package com.example

import io.ktor.util.*
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class UserCredentials(val login: String, val password: String)

object UserStorage {
    private val users = mutableMapOf<String, String>() // login -> hashed password
    private val tokenStorage = mutableMapOf<String, String>() // login -> token

    fun register(login: String, password: String): String? {
        if (users.containsKey(login)) return null // User already exists
        val hashedPassword = password.encodeBase64()
        users[login] = hashedPassword
        val token = generateToken(login)
        tokenStorage[login] = token
        return token
    }

    fun authenticate(login: String, password: String): String? {
        val hashedPassword = users[login] ?: return null
        if (hashedPassword != password.encodeBase64()) return null
        return tokenStorage[login] ?: generateToken(login).also { tokenStorage[login] = it }
    }

    fun validateToken(token: String): Boolean {
        return tokenStorage.containsValue(token)
    }

    private fun generateToken(login: String): String {
        return Base64.getEncoder().encodeToString("token_for_$login".toByteArray())
    }
}