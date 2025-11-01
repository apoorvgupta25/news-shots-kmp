package extension

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.provider.Provider

internal val VersionCatalog.ktlint: Provider<MinimalExternalModuleDependency>
    get() = getLibrary("ktlint")

private fun VersionCatalog.getLibrary(library: String) = findLibrary(library).get()
