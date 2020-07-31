plugins {
    `java-library`
}

tasks.register<Jar>("agentJarTask"){
    manifest{
        attributes(mapOf("Premain-Class" to "com.github.yashashripendse.Agent", "Can-Redefine-Classes" to "true"))
    }
    archiveClassifier.set("with-manifest")

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

    from(sourceSets.main.get().output)
}

dependencies{
    implementation("org.ow2.asm", "asm", "8.0.1")
    implementation("org.ow2.asm", "asm-commons", "8.0.1")
}