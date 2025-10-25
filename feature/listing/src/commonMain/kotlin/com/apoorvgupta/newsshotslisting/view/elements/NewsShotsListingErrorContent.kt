package com.apoorvgupta.newsshotslisting.view.elements

import androidx.compose.runtime.Composable
import com.apoorvgupta.designsystem.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingViewStates

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
