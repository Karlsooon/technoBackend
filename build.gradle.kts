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
	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-security")
	}
	implementation("org.springframework.boot:spring-boot-starter-validation")
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


	implementation("commons-io:commons-io:2.7")
	implementation(kotlin("stdlib-jdk8"))


	// security dependents , own add
	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation ("com.auth0:java-jwt:4.2.1")
	implementation ("org.modelmapper:modelmapper:3.1.1")

//	implementation ("com.h2database:h2:2.1.214")
	implementation ("com.h2database:h2")
//	implementation ("io.springfox:springfox-boot-starter")

}
kotlin {
	jvmToolchain(17)
}