import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {
    setFrameworkBaseName("coreKit")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // Logging
            implementation(libs.napier)

            // Koin
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.apoorvgupta.core"
}