plugins {
    kotlin("jvm") version "1.6.21"
    java
    id("java-gradle-plugin")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("kApiDocGen") {
            id = "kim.bifrost.rain.kapidocgen"
            implementationClass = "kim.bifrost.rain.kapidocgen.KApiDocGenPlugin"
        }
    }
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.javassist:javassist:3.28.0-GA")
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}