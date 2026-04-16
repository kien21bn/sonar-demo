plugins {
    kotlin("jvm") version "2.1.0"
    id("org.sonarqube") version "7.2.3.7755"
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
    }
}

sonar {
    properties {
        property("sonar.projectKey", "kien21bn_mapstruct-sonar-demo")
        property("sonar.organization", "kien21bn")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

kotlin {
    jvmToolchain(23)
}