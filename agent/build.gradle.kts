plugins {
    `java-library`
}

tasks.register<Jar>("agentJarTask"){
    manifest{
        attributes(mapOf("Premain-Class" to "com.github.yashashripendse.Agent", "Can-Redefine-Classes" to "true"))
    }
    archiveClassifier.set("with-manifest")

    from(sourceSets.main.get().output)
}