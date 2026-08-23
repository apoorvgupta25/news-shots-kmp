import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    setFrameworkBaseName("designsystemKit")

    sourceSets {
        sourceSets {
            commonMain.dependencies {
                // Projects
                implementation(projects.core)
                implementation(projects.domain)

                // Compose
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.components.resources)


                // Navigation
                implementation(libs.jetbrains.compose.navigation)

                // Coil
                implementation(libs.bundles.coil)

            }
        }
    }

    android {
        namespace = "com.apoorvgupta.designsystem"

        // to share Resources across module
        androidResources.enable = true
    }
}