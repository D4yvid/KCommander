plugins {
    id("java")
    id("io.freefair.lombok") version "8.7.1"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.kayllon.douglas"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies.compileOnly(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))