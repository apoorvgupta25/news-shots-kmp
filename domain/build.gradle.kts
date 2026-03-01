import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {
    setFrameworkBaseName("domainKit")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core)
            implementation(projects.library.draftjskmp)

            // Ktor Json serialization
            implementation(libs.ktor.serialization.kotlinx.json)

            // Pagination
            implementation(libs.androidx.pagination)
        }
    }
    androidLibrary {
        namespace = "com.apoorvgupta.domain"
    }
}