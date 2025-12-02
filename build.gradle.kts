plugins {
    kotlin("jvm") version "2.2.0"
    application
}

group = "dev.icefish"
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

kotlin {
    jvmToolchain(21)
}

// Create individual tasks for each day
val days = listOf("Day1", "Day2", "Day3", "Day4")

days.forEach { day ->
    tasks.register<JavaExec>("run$day") {
        group = "advent"
        description = "Run $day"
        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("dev.icefish.${day}Kt")
    }
}

// Create task to run all days
tasks.register("runAll") {
    group = "advent"
    description = "Run all days"
    dependsOn(days.map { "run$it" })
}
