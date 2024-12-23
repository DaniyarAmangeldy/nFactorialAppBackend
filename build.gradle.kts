plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    application
    id("io.ktor.plugin") version "2.3.3"
}

group = "com.example"
version = "0.0.1"

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.Application") // Указываем главный класс
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
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