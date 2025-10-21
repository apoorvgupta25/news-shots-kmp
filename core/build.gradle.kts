plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {

    androidLibrary {
        namespace = "com.apoorvgupta.newsshotskmp.core"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        /*
  withHostTestBuilder {
  }

  withDeviceTestBuilder {
      sourceSetTreeName = "test"
  }.configure {
      instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  */
    }

    val xcfName = "coreKit"

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
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // Logging
            implementation(libs.napier)

            // Koin
            api(libs.koin.core)
        }

        androidMain.dependencies {

        }

        iosMain.dependencies {

        }
    }
}