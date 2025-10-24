plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {

    androidLibrary {
        namespace = "com.apoorvgupta.server"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "databaseKit"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core)

            // Ktor Json serialization
            implementation(libs.ktor.serialization.kotlinx.json)
        }
    }
}