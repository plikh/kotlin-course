plugins {
    kotlin("jvm") version "2.0.10"
}

group = "com.pavel.likholap"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}