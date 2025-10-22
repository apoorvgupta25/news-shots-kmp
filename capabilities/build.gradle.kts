plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    
    androidLibrary {
        namespace = "com.apoorvgupta.newsshotskmp.capabilities"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        // to share Resources across module
        androidResources.enable = true
    }

    val xcfName = "capabilitiesKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        sourceSets {
            commonMain.dependencies {
                implementation(projects.core)

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)

                // Navigation
                implementation(libs.jetbrains.compose.navigation)

                // Koin
                api(libs.koin.core)

                // Ktor
                implementation(libs.bundles.ktor)

                // Coil
                implementation(libs.bundles.coil)

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
}