import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm")
}

group = "go.tracker"

repositories {
    mavenCentral()
}

dependencies {
    // Modules
    implementation(project(":go-tracker-persistence"))
    implementation(project(":go-tracker-models"))
    implementation(project(":go-tracker-commons"))


    //Utils
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.springframework:spring-context:6.1.6")

    //Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.withType<BootJar>{
    enabled = false
}

tasks.jar {
    enabled = true
}