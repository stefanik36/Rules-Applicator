import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "com.stefanik36"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")

    //plots
    implementation("space.kscience:plotlykt-server:0.5.0")

    //logs
    runtimeOnly("ch.qos.logback:logback-classic:1.2.6")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")

    //tests
    testImplementation("net.wuerl.kotlin:assertj-core-kotlin:0.2.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}
