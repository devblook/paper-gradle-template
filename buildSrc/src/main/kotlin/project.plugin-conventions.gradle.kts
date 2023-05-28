plugins {
    `java-library`
}

repositories {
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
    mavenCentral()
}

tasks {

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    getByName<Test>("test") {
        useJUnitPlatform()
    }
}