import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {

    setFrameworkBaseName("bookmarkKit")

    sourceSets {

    }
}

android {
    namespace = "com.apoorvgupta.bookmark"
}