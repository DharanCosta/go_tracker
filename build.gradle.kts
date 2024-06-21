import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    extra["databaseMigrationVersion"] = "2.0.0"

    repositories {
        mavenCentral()
    }

    dependencies {
//        classpath("database-migration-plugin:database-migration-plugin:${property("databaseMigrationVersion")}")
    }
}

plugins {
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"

    id("application")
//    id("gt.databaseMigration") version "2.0.0"
}

group = "go.tracker"
//java.sourceCompability = JavaVersion.VERSION_17
//java.targetCompability = JavaVersion.VERSION_17

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

extra["springCloudVersion"] = "2022.0.3"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    configurations {
        all {
            exclude(module = "slf4j-log4j12")
        }
    }

    dependencies {

        // Spring
        implementation("io.micrometer:micrometer-tracing:1.1.4")
        implementation("io.micrometer:micrometer-tracing-bridge-brave")


        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Utils
        implementation("io.github.cdimascio:java-dotenv:5.2.2")


        // Test
        testImplementation("io.mockk:mockk:1.13.7")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.0")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.mockito:mockito-core:5.5.0")

    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

tasks.withType<BootJar>{
    enabled = false
}

tasks.jar {
    enabled = true
}
