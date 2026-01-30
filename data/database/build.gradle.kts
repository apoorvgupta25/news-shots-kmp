import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {
    setFrameworkBaseName("databaseKit")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core)

            // Ktor Json serialization
            implementation(libs.ktor.serialization.kotlinx.json)
        }
    }

    androidLibrary {
        namespace = "com.apoorvgupta.server"
    }
}