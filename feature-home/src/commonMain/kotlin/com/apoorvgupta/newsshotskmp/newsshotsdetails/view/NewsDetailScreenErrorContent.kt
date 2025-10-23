package com.apoorvgupta.newsshotskmp.newsshotsdetails.view

import androidx.compose.runtime.Composable
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsViewStates

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailScreenErrorContent(
    state: NewsDetailsViewStates.ErrorData,
    userIntent: (NewsDetailsIntent) -> Unit,
) {
    AppErrorScreen(
        isRefreshing = state.showLoader,
        onRefresh = {
            userIntent.invoke(NewsDetailsIntent.RefreshNewsDetailsScreen)
        },
        errorMessage = "${state.data.errorModel.errorCode} ${state.data.errorModel.message}",
    )
}
