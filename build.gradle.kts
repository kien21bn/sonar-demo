plugins {
    kotlin("jvm") version "2.1.0"
    id("org.sonarqube") version "5.1.0.4882"
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
        property("sonar.projectKey", "kotlin-demo")
        property("sonar.projectName", "Kotlin Demo")
        property("sonar.coverage.jacoco.xmlReportPaths", "${layout.buildDirectory.get()}/reports/jacoco/test/jacocoTestReport.xml")
    }
}

kotlin {
    jvmToolchain(23)
}