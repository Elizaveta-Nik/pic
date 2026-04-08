import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.seleniumhq.selenium:selenium-java:4.28.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
    testImplementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    testImplementation("io.github.oshai:kotlin-logging-jvm:7.0.3")
    testImplementation("ch.qos.logback:logback-classic:1.5.16")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped")
        showStandardStreams = true
        exceptionFormat = TestExceptionFormat.FULL
    }
}

kotlin {
    jvmToolchain(21)
}