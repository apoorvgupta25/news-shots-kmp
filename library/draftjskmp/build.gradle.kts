import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    setFrameworkBaseName("draftjskmpKit")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.material3)
            implementation(compose.ui)
        }
    }
}

android {
    namespace = "com.apoorvgupta.draftjskmp"
}