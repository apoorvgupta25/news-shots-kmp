import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {

    setFrameworkBaseName("datastoreKit")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core)
            implementation(projects.domain)

            // Koin
            implementation(libs.koin.core)

            // Datastore
            implementation(libs.datastore.preferences.core)
        }
    }

    androidLibrary {
        namespace = "com.apoorvgupta.datastore"
    }
}