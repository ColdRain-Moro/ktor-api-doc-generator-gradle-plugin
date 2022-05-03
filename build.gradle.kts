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
    implementation("org.ow2.asm:asm:9.3")
    implementation("org.ow2.asm:asm-commons:9.3")
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}