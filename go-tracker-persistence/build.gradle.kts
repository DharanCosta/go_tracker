import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
//    id("gt.databaseMigration")
}

group = "go.tracker"

val env: String? = System.getProperty("env")
//databaseMigration.invokeMethod("setLocations", "filesystem:${projectDir}/database/gotracker")
//
//databaseMigration {
//    databases.create("go-tracker-dev") {
//        name = "go-tracker-dev"
//        url = ""
//        user = ""
//        password = "trackerPkmGO55"
//    }
//}

allOpen{
    annotation("jakarta.persistence.Entity")
}

dependencies {
    // Modules
    implementation(project(":go-tracker-models"))
    implementation(project(":go-tracker-commons"))


    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Postgres
    runtimeOnly("org.postgresql:postgresql")

    // Test
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