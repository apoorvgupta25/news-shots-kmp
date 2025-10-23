package com.apoorvgupta.newsshotskmp.newsshotslisting.view.elements

import androidx.compose.runtime.Composable
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingViewStates

@Composable
fun NewsShotsListingErrorContent(
    state: NewsShotsListingViewStates.LoadedData,
    userIntent: (NewsShotsListingIntent) -> Unit,
    error: String,
) {
    AppErrorScreen(
        isRefreshing = state.showLoader,
        onRefresh = { userIntent.invoke(NewsShotsListingIntent.RefreshNewsShotsListingScreen) },
        errorMessage = error,
    )
}
