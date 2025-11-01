package com.apoorvgupta.newsshotskmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.apoorvgupta.designsystem.navigation.Destinations
import com.apoorvgupta.home.navigation.HomeScreenDestination
import com.apoorvgupta.home.viewmodel.HomeViewModel
import com.apoorvgupta.newsshotsdetails.navigation.NewsDetailsScreenDestination
import com.apoorvgupta.newsshotsdetails.viewmodel.NewsDetailsViewModel
import com.apoorvgupta.newsshotslisting.navigation.NewsShotsListingScreenDest
import com.apoorvgupta.newsshotslisting.viewmodel.NewsShotsListingViewModel
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
        val viewModel: NewsShotsListingViewModel = koinViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect

        val arg = it.toRoute<Destinations.NewsShotsListing>()
        NewsShotsListingScreenDest(
            newsShotsListingViewModel = viewModel,
            newsShotsListingViewState = viewState.newsShotsListingViewState,
            navEffect = effect,
            navController = navController,
            arg = arg,
        )
    }

    composable<Destinations.NewsDetails> {
        val viewModel: NewsDetailsViewModel = koinViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect

        val arg = it.toRoute<Destinations.NewsDetails>()

        NewsDetailsScreenDestination(
            newsDetailsViewModel = viewModel,
            newsDetailsViewState = viewState.newsDetailsViewState,
            navEffect = effect,
            navController = navController,
            arg = arg,
        )
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
