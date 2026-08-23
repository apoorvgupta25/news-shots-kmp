import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    setFrameworkBaseName("listingKit")

    sourceSets {
        commonMain.dependencies {
            // Projects
            implementation(projects.core)
            implementation(projects.domain)

            implementation(projects.library.coroutines)
            implementation(projects.library.designsystem)

            // Compose
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)

            // Navigation
            implementation(libs.jetbrains.compose.navigation)

            // Koin
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.core)

            // Pagination
            implementation(libs.androidx.pagination)
        }
    }

    android {
        namespace = "com.apoorvgupta.listing"
    }
}