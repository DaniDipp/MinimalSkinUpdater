plugins {
  `java-library`
//   id("io.papermc.paperweight.userdev") version "1.5.11"
//   id("xyz.jpenilla.run-paper") version "2.2.2" // Adds runServer and runMojangMappedServer tasks for testing
}

group = "com.danidipp.minimalskinupdater"
version = "1.0.0-SNAPSHOT"
description = "Proof-of-concept Paper plugin for updating player skins on the fly"

java {
  // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}