package com.apoorvgupta.newsshotskmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.Destinations

/**
 * Defines the navigation graph for the Home screen.
 */
fun NavGraphBuilder.homeNavigationGraph(
    navController: NavHostController,
) {
    composable<Destinations.Home> {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text("Home")
            Button(
                onClick = {
                    navController.navigate(Destinations.NewsShotsListing("Das"))
                }
            ) {
                Text("Click Me")
            }

        }
    }

    composable<Destinations.NewsShotsListing> {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text("NewsShotsListing")
            Button(
                onClick = {
                    navController.navigate(Destinations.NewsDetails("ss"))
                }
            ) {
                Text("Click Me")
            }

            Button(
                onClick = {
                    navController.navigate(Destinations.NewsDetails("as"))
                }
            ) {
                Text("Back")
            }
        }
    }

    composable<Destinations.NewsDetails> {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text("NewsDetails")
            Button(
                onClick = {
                    navController.navigate(Destinations.NewsDetails)
                }
            ) {
                Text("Click Me")
            }

            Button(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Text("Back")
            }
        }
    }
}

fun NavGraphBuilder.searchNavigationGraph() {
    composable<Destinations.Search> {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text("Search")
        }
    }
}

fun NavGraphBuilder.bookmarkNavigationGraph() {
    composable<Destinations.Bookmark> {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text("BookMark")
        }
    }
}
