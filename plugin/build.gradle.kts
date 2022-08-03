plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version("0.5.2")
    id("com.github.johnrengelman.shadow") version("7.1.2")
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.1-R0.1-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

bukkit {

    main = "io.devblook.template.PluginTemplate"
    name = project.name
    apiVersion = "1.13"
    version = "${project.version}"

    author = "DevBlook"
    softDepend = listOf("Vault", "PlaceholderAPI")

    commands {
        register("template") {
            description = "Command template"
            aliases = listOf("tmp", "t")
            permission = "template.command"
            usage = "/template help"
        }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}