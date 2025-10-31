import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {

    setFrameworkBaseName("searchKit")

    sourceSets {

    }
}

android {
    namespace = "com.apoorvgupta.search"
}
