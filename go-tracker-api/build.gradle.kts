plugins {
    kotlin("jvm")
    id("application")
}

group = "go.tracker"

application {
    mainClass.set("go.tracker.api.GoTrackerApplication.kt")
}

springBoot {
    buildInfo()
}

repositories {
    mavenCentral()
}

dependencies {
    // Modules
    implementation(project(":go-tracker-domain"))
    implementation(project(":go-tracker-models"))
    implementation(project(":go-tracker-commons"))

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Spring Security
    implementation("org.springframework.security:spring-security-core")
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
    implementation("org.springframework.security:spring-security-crypto")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2") // Updated implementation
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2") // Jackson serializer

    // Hawtio
    implementation("io.hawt:hawtio-springboot:4.0.0")

    // Open API
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // Servlet API
    implementation("jakarta.servlet:jakarta.servlet-api:5.0.0")

    // Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}