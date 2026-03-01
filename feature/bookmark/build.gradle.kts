import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {

    setFrameworkBaseName("bookmarkKit")

    sourceSets {

    }

    androidLibrary {
        namespace = "com.apoorvgupta.bookmark"
    }
}