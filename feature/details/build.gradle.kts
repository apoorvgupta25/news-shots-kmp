import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    setFrameworkBaseName("detailsKit")

    sourceSets {
        commonMain.dependencies {
            // Projects
            implementation(projects.core)
            implementation(projects.domain)

            implementation(projects.library.coroutines)
            implementation(projects.library.designsystem)
            implementation(projects.library.draftjskmp)

            // Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)

            // Navigation
            implementation(libs.jetbrains.compose.navigation)

            // Koin
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            api(libs.koin.core)

            // Coil
            implementation(libs.bundles.coil)

        }
    }
}

android {
    namespace = "com.apoorvgupta.details"
}
