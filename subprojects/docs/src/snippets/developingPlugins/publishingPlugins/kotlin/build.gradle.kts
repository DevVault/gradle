// tag::plugins_block[]
plugins {
    id("com.gradle.plugin-publish") version "0.20.0"
}
// end::plugins_block[]

// tag::gradle-plugin[]
group = "io.github.johndoe" // <1>
version = "1.0" // <2>

gradlePlugin {
    plugins { // <3>
        create("greetingsPlugin") { // <4>
            id = "<your plugin identifier>" // <5>
            displayName = "<short displayable name for plugin>" // <6>
            description = "<human-readable description of what your plugin is about>" // <7>
            tags = listOf("tags", "for", "your", "plugins") // <8>
            implementationClass = "<your plugin class>"
        }
    }
}
// end::gradle-plugin[]

// tag::plugin_bundle[]
pluginBundle {
    website = "<substitute your project website>" // <1>
    vcsUrl = "<uri to project source repository>" // <2>
    description = "<human-readable description of what your plugins are about>" // <3>
    tags = listOf("tags", "for", "your", "plugins") // <4>
}
// end::plugin_bundle[]

// tag::local_repository[]
publishing {
    repositories {
        maven {
            name = "localPluginRepository"
            url = uri("../local-plugin-repository")
        }
    }
}
// end::local_repository[]
