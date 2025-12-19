plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modCompileOnly(libs.puzzleslib.common)
    modApi(libs.puzzleslib.neoforge)
}

multiloader {
    modFile {
        enumExtensions.set("META-INF/enumextensions.json")
    }
}
