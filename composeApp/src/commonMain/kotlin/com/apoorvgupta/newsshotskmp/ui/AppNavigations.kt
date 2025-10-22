package com.apoorvgupta.newsshotskmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.Destinations
import com.apoorvgupta.newsshotskmp.home.navigation.HomeScreenDestination
import com.apoorvgupta.newsshotskmp.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

/**
 * Defines the navigation graph for the Home screen.
 */
fun NavGraphBuilder.homeNavigationGraph(
    navController: NavHostController,
) {
    composable<Destinations.Home> {
        val viewModel: HomeViewModel = koinViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect

        HomeScreenDestination(
            homeViewModel = viewModel,
            homeViewState = viewState.homeViewState,
            navEffect = effect,
            navController = navController,
        )
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
