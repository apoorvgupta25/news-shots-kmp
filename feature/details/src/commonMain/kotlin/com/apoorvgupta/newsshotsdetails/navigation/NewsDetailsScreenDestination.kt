package com.apoorvgupta.newsshotsdetails.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.apoorvgupta.newsshotsdetails.view.NewsDetailScreenErrorContent
import com.apoorvgupta.newsshotsdetails.view.NewsDetailScreenLoadedContent
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.Destinations
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.newsshotsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsshotsdetails.intent.NewsDetailsNavEffect
import com.apoorvgupta.newsshotsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsshotsdetails.viewmodel.NewsDetailsViewModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailsScreenDestination(
    newsDetailsViewModel: NewsDetailsViewModel,
    newsDetailsViewState: NewsDetailsViewStates,
    navEffect: Flow<NewsDetailsNavEffect>,
    navController: NavController,
    arg: Destinations.NewsDetails,
) {
    /**
     * Handles navigation based on [NewsDetailsNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: NewsDetailsNavEffect) {
        when (navEvent) {
            // Need to update
            is NewsDetailsNavEffect.OpenChromeCustomTab -> {
            }

            is NewsDetailsNavEffect.OpenIndividualNewsShots -> {
                navController.navigate(
                    Destinations.NewsDetails(postLink = navEvent.postLink),
                )
            }

            NewsDetailsNavEffect.OpenPreviousScreen -> {
                navController.popBackStack()
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Adding Base Section for Home
        // Perform the FetchNewsDetails action when the composable is launched.
        newsDetailsViewModel.performAction(NewsDetailsIntent.LoadNewsDetailsScreen(postLink = arg.postLink))
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [NewsDetailsIntent] as a parameter.
     */
    fun onUserAction(): (NewsDetailsIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        newsDetailsViewModel.performAction(it)
    }

    // Main content of the News Details Destination.
    // Choose the appropriate content based on the current state of the News Details.

    when (newsDetailsViewState) {
        is NewsDetailsViewStates.LoadedData -> {
            // Display the Home Screen with loaded data.
            NewsDetailScreenLoadedContent(
                state = newsDetailsViewState,
                userIntent = onUserAction(),
            )
        }

        is NewsDetailsViewStates.ErrorData -> {
            // Display the Home Screen with error data.
            NewsDetailScreenErrorContent(
                state = newsDetailsViewState,
                userIntent = onUserAction(),
            )
        }

        is NewsDetailsViewStates.Loading -> {
            CircularProgressBarComponent(newsDetailsViewState.showLoader)
        }

        is NewsDetailsViewStates.UnInitialized -> {
            // Do Nothing.
        }
    }
}
