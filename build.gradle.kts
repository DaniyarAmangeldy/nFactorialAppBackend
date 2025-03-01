plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.10"
    application
    id("io.ktor.plugin") version "3.1.1"
}

group = "com.example"
version = "0.0.1"

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.ApplicationKt") // Указываем главный класс
}

dependencies {
    implementation("io.ktor:ktor-server-core:3.1.1")
    implementation("io.ktor:ktor-server-auth-jwt:3.1.1")
    implementation("io.ktor:ktor-server-netty:3.1.1")
    implementation("io.ktor:ktor-server-swagger:3.1.1")
    implementation("io.ktor:ktor-server-cors:3.1.1")
    implementation("io.ktor:ktor-server-openapi:3.1.1")
    implementation("io.github.smiley4:ktor-swagger-ui:5.0.0-beta.2")
    implementation("io.github.smiley4:ktor-openapi:5.0.0-beta.2")
    implementation("io.ktor:ktor-server-content-negotiation:3.1.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.1.1")
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "com.example.ApplicationKt"
        }
        // Включаем все зависимости в JAR
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}