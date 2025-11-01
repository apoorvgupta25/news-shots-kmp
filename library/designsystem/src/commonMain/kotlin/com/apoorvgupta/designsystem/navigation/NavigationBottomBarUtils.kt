package com.apoorvgupta.designsystem.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Show Navigation BottomBar - Function to show / hide Navigation BottomBar based on the current BackStack Entry
 *
 * @param navController to get the current BackStack Entry
 * @return to Show or hide the Navigation BottomBar for the current BackStack Entry
 *
 * @author Apoorv Gupta
 * Jan, 2025
 *
 */
@Composable
fun showNavigationBottomBar(navController: NavController): Boolean {
    val route = navController.currentBackStackEntryAsState().value?.destination?.route
    if (route.isNullOrEmpty()) {
        return false
    }
    return route.substringAfterLast(".") in navigationBottomBarDestinationRoutes
}

/**
 * Display navigation BottomBar destinations
 *
 * list of Destination for which Navigation BottomBar has to be shown
 */
private val displayNavigationBottomBarDestinations =
    listOf(
        Destinations.Home,
        Destinations.Search,
        Destinations.Bookmark,
    )

/**
 * Navigation BottomBar destination routes
 *
 * Mapping the Destination with their route
 * No change required if there are no arguments,
 * If arguments are there add full path of the route along with argument key according to nav graph of that screen
 */
val navigationBottomBarDestinationRoutes =
    displayNavigationBottomBarDestinations.map {
        it::class.simpleName
    }
