package com.apoorvgupta.newsshotslisting.view

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingViewStates
import com.apoorvgupta.newsshotslisting.view.elements.NewsShotsListingErrorContent
import com.apoorvgupta.newsshotslisting.view.elements.NewsShotsListingLoadedContent
import com.apoorvgupta.newsshotslisting.viewmodel.NewsShotsListingViewModel

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsShotsListingScreen(
    state: NewsShotsListingViewStates.LoadedData,
    viewModel: NewsShotsListingViewModel,
    userIntent: (NewsShotsListingIntent) -> Unit,
) {
    val newsShotsResults = viewModel.newsShotsPaginationResults.collectAsLazyPagingItems()

    // Loaded Content
    NewsShotsListingLoadedContent(
        state = state,
        userIntent = userIntent,
        newsShotsResults = newsShotsResults,
    )

    // Error and Loading State
    when (newsShotsResults.loadState.refresh) {
        is LoadState.Error -> {
            NewsShotsListingErrorContent(
                state = state,
                userIntent = userIntent,
                error = (newsShotsResults.loadState.refresh as LoadState.Error).error.message.getValueOrEmpty(),
            )
        }

        LoadState.Loading -> {
            CircularProgressBarComponent(true)
            AppLogger.d { "newsShotsResults.loadState.refresh.Loading" }
        }

        is LoadState.NotLoading -> AppLogger.d { "newsShotsResults.loadState.refresh.NotLoading" }
    }

    when (newsShotsResults.loadState.append) {
        is LoadState.Error -> {
            NewsShotsListingErrorContent(
                state = state,
                userIntent = userIntent,
                error = (newsShotsResults.loadState.append as LoadState.Error).error.message.getValueOrEmpty(),
            )
        }

        LoadState.Loading -> AppLogger.d { "newsShotsResults.loadState.append.Loading" }
        is LoadState.NotLoading -> AppLogger.d { "newsShotsResults.loadState.append.NotLoading" }
    }
}
