import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Permet à JAVA de se connecter à une base SQL
    //runtimeOnly 'mysql:mysql-connector-j'
    runtimeOnly("com.mysql:mysql-connector-j")

    //JPA Framework Java qui génère du SQL
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //Le validator hibernate
    implementation("org.springframework.boot:spring-boot-starter-validation")

    developmentOnly("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.+")

    //Permet à JAVA de se connecter à une base SQL
    //runtimeOnly 'mysql:mysql-connector-java'
    runtimeOnly("com.mysql:mysql-connector-j")

    //JPA Framework Java qui génère du SQL
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //Le validator hibernate
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // OKHTTP et session
    implementation("com.squareup.okhttp3:okhttp-urlconnection:+")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
