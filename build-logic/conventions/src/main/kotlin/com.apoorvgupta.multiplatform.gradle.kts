import extension.sdkCompile
import extension.sdkMin
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    compileSdk = Integer.parseInt(libs.sdkCompile)
    defaultConfig {
        minSdk = Integer.parseInt(libs.sdkMin)
    }
}

