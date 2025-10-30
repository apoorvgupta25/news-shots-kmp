package com.apoorvgupta.newsshotskmp.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import com.apoorvgupta.designsystem.navigation.Destinations

/**
 * NavigationHost composable function.
 *
 * This composable function represents the navigation host for the Newsshots Android application.
 * It is responsible for defining the navigation graph using Jetpack Compose Navigation.
 *
 * @param navController The NavHostController responsible for navigating between destinations.
 *
 * @author Apoorv Gupta
 */
@Composable
fun NavigationHost(
    navController: NavHostController,
    paddingTop: Dp,
) {
    // NavHost is used to define the navigation graph with various destination composable functions.
    NavHost(
        navController = navController,
        startDestination = Destinations.NewsGraph,
        modifier = Modifier.padding(top = paddingTop),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        navigation<Destinations.NewsGraph>(
            startDestination = Destinations.Home,
        ) {
            homeNavigationGraph(
                navController = navController,
            )

            searchNavigationGraph()

            bookmarkNavigationGraph()
        }
    }
}
