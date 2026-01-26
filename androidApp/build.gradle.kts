plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
    id("com.apoorvgupta.kotlin-quality")
}

android {
    namespace = "com.apoorvgupta.newsshotskmp"
    defaultConfig {
        applicationId = "com.apoorvgupta.newsshotskmp"

        versionCode = Integer.parseInt(libs.versions.version.code.get())
        versionName = libs.versions.version.name.get()

        compileSdk = Integer.parseInt(libs.versions.android.compileSdk.get())
        minSdk = Integer.parseInt(libs.versions.android.minSdk.get())
        targetSdk = Integer.parseInt(libs.versions.android.targetSdk.get())

        base.archivesName.set("${parent?.name}-$versionName")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.ktor.client.okhttp)

    implementation(projects.app)
    implementation(projects.core)
}