rootProject.name = "NewsshotsKMP"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":app")
include(":core")
include(":data:datastore")
include(":data:database")
include(":data:network")
include(":domain")
include(":feature:home")
include(":feature:details")
include(":feature:listing")
include(":feature:bookmark")
include(":feature:search")
include(":library:designsystem")
include(":library:draftjskmp")
include(":library:coroutines")
