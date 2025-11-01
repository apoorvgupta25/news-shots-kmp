import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

kotlin {

    setFrameworkBaseName("networkKit")

    sourceSets {
        commonMain.dependencies {
            // Projects
            implementation(projects.core)
            implementation(projects.domain)

            // Ktor
            implementation(libs.bundles.ktor)

            // Pagination
            implementation(libs.androidx.pagination)
        }

        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.apoorvgupta.network"
}