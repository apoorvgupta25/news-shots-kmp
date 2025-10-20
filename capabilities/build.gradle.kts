plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    
    androidLibrary {
        namespace = "com.apoorvgupta.newsshotskmp.capabilities"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
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
            }

            androidMain.dependencies {

            }

            iosMain.dependencies {

            }
        }
    }
}