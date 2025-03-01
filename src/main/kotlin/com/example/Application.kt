package com.example

import com.example.data.MockData
import com.example.models.*
import io.github.smiley4.ktoropenapi.OpenApi
import io.github.smiley4.ktoropenapi.openApi
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
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
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }
    install(OpenApi)

    install(Authentication) {
        jwt("auth-jwt") {
            verifier(JwtConfig.verifier)
            validate { credential ->
                if (credential.payload.getClaim("login").asString().isNotEmpty()) {
                    JWTPrincipal(credential.payload)
                } else null
            }
        }
    }

    routing {
        route("/api.json") {
            openApi()
        }
        route("/swagger") {
            swaggerUI("/api.json")
        }
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

        get("/products") {
            val query = call.request.queryParameters.get("query")
            if (query == null) {
                call.respond(Products(MockData.products))
                return@get
            }
            val products = MockData.products.filter { product ->
                product.name.contains(query, ignoreCase = true)
            }
            call.respond(Products(products))
        }

        post("/profile") {
            val request = call.receive<ProfileUpdateRequest>()
            MockData.updateProfile(request.name, request.size)
            call.respond(MockData.getProfile())
        }

        post("/auth/register") {
            val credentials = call.receive<UserCredentials>()
            val token = JwtConfig.generateToken(credentials.login)
            call.respond(mapOf("token" to token))
        }

        post("/auth/login") {
            val credentials = call.receive<UserCredentials>()
            val token = JwtConfig.generateToken(credentials.login)
            call.respond(mapOf("token" to token))
        }

        authenticate("auth-jwt") {
            get("/auth/validate") {
                val principal = call.principal<JWTPrincipal>()
                val login = principal?.payload?.getClaim("login")?.asString()
                call.respond(mapOf("message" to "Valid token", "login" to login))
            }
        }

        authenticate("auth-jwt") {
            get("/home") {
                val tagFilter = call.request.queryParameters["tag"]
                val filteredCourses = tagFilter?.let { tag -> courses.filter { it.tags.contains(tag) } } ?: courses
                call.respond(
                    mapOf(
                        "banners" to banners,
                        "courses" to filteredCourses,
                        "tags" to tags,
                    )
                )
            }
        }

        authenticate("auth-jwt") {
            get("/catalog") {
                val tagFilter = call.request.queryParameters["tag"]
                val filteredCourses = tagFilter?.let { tag -> courses.filter { it.tags.contains(tag) } } ?: courses
                call.respond(
                    mapOf(
                        "courses" to filteredCourses,
                        "tags" to tags,
                    )
                )
            }
        }

        authenticate("auth-jwt") {
            get("/feedback") {
                call.respond(
                    mapOf("feedbacks" to testimonials)
                )
            }
        }

        authenticate("auth-jwt") {
            get("/news") {
                val tagFilter = call.request.queryParameters["tag"]
                val filteredNews = tagFilter?.let { tag -> newsList.filter { it.tags.contains(tag) } } ?: newsList
                call.respond(
                    mapOf(
                        "news" to filteredNews,
                        "tags" to newsTags,
                    )
                )
            }
        }

        authenticate("auth-jwt") {
            post("/consultation") {
                val request = call.receive<ConsultationRequest>()
                if (request.name.isBlank() || request.email.isBlank() || request.phone.isBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Все поля должны быть заполнены")
                } else {
                    call.respond(HttpStatusCode.OK, "Заявка принята")
                }
            }
        }
    }
}