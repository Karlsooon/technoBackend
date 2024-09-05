plugins {
	java
	id("org.springframework.boot") version "3.0.8"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm")
}

group = "techno.hub"
version = "0.0.1-SNAPSHOT"

java {
}

configurations {
	val compileOnly by getting {
		extendsFrom(configurations.getByName("annotationProcessor"))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.slf4j:slf4j-api:2.0.9")

	testImplementation("ch.qos.logback:logback-classic:1.4.12")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.security:spring-security-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-config")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")
	implementation("org.apache.commons:commons-lang3:3.12.0")

	implementation("org.mapstruct:mapstruct:1.5.3.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")

	implementation ("io.jsonwebtoken:jjwt-api:0.12.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.12.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.12.5")


	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")


	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("commons-io:commons-io:2.7")
	implementation(kotlin("stdlib-jdk8"))
}
kotlin {
	jvmToolchain(17)
}