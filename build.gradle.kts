plugins {
    id("java-library")
    id("maven-publish")
}

group = "jlg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("junit:junit:4.13.1")
    testImplementation("pl.pragmatists:JUnitParams:1.1.1")
    testImplementation("org.mockito:mockito-core:1.10.19")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}

tasks.test {
    useJUnitPlatform()
}