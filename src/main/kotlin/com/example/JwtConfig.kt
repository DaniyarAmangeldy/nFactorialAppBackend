package com.example

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

object JwtConfig {
    private const val secret = "super_secret_key" // Храни в .env или Secrets
    private val algorithm = Algorithm.HMAC256(secret)

    val verifier = JWT.require(algorithm).build()

    fun generateToken(login: String): String {
        return JWT.create()
            .withSubject("Auth")
            .withClaim("login", login)
            .withExpiresAt(Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 час
            .sign(algorithm)
    }
}