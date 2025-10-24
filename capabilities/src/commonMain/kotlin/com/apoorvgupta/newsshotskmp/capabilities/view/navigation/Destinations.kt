package com.apoorvgupta.newsshotskmp.capabilities.view.navigation

import kotlinx.serialization.Serializable

/**
 * Sealed interface representing different destinations in the app.
 *
 * @author Apoorv Gupta
 */

sealed interface Destinations {

    @Serializable
    data object NewsGraph : Destinations

    // Home Destination
    @Serializable
    object Home : Destinations

    // NewsShotsListing Destination
    @Serializable
    data class NewsShotsListing(
        val categoryName: String,
    ) : Destinations

    // NewsShotsDetails Destination
    @Serializable
    data class NewsDetails(
        val postLink: String,
    ) : Destinations

    // Search Destination
    @Serializable
    object Search : Destinations

    // Bookmark Destination
    @Serializable
    object Bookmark : Destinations
}
