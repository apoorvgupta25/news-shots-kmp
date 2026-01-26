import extension.setFrameworkBaseName

plugins {
    id("com.apoorvgupta.multiplatform")
}

kotlin {

    setFrameworkBaseName("searchKit")

    sourceSets {

    }

    androidLibrary {
        namespace = "com.apoorvgupta.search"
    }

}