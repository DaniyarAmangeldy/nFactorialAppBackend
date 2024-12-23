package org.example.com.example

import com.example.data.MockData
import com.example.models.ProfileUpdateRequest
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    embeddedServer(Netty, port = port) { module() }.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/home") {
            call.respond(MockData.homeComponent)
        }

        get("/store/{id}") {
            val id = call.parameters["id"]
            val store = id?.let { MockData.getStore(it) }
            if (store != null) {
                call.respond(store)
            } else {
                call.respond(HttpStatusCode.NotFound, "Store not found")
            }
        }

        get("/profile") {
            call.respond(MockData.getProfile())
        }

        post("/profile") {
            val request = call.receive<ProfileUpdateRequest>()
            MockData.updateProfile(request.name, request.size)
            call.respond(MockData.getProfile())
        }
    }
}