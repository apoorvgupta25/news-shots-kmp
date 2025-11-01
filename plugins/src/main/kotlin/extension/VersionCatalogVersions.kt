package extension

import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.sdkCompile: String
    get() = findVersion("android.compileSdk").get().requiredVersion

val VersionCatalog.sdkMin: String
    get() = findVersion("android.minSdk").get().requiredVersion
