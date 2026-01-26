
plugins {
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    id("com.apoorvgupta.multiplatform")
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "app"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Projects
            implementation(projects.core)
            implementation(projects.domain)

            implementation(projects.library.designsystem)
            implementation(projects.library.coroutines)

            implementation(projects.data.datastore)
            implementation(projects.data.network)

            implementation(projects.feature.home)
            implementation(projects.feature.details)
            implementation(projects.feature.listing)

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
            implementation(libs.koin.core)

        }
    }

    androidLibrary {
        namespace = "com.apoorvgupta.app"
    }
}