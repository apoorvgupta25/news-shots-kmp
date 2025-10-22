package com.apoorvgupta.newsshotskmp.home.view

import androidx.compose.runtime.Composable
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsshotskmp.home.intent.HomeIntent
import com.apoorvgupta.newsshotskmp.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun HomeScreenErrorContent(
    state: HomeViewStates.ErrorData,
    userIntent: (HomeIntent) -> Unit,
) {
    AppErrorScreen(
        isRefreshing = state.showLoader,
        onRefresh = {
            userIntent.invoke(HomeIntent.LoadHomeScreen)
        },
        errorMessage = "${state.data.errorModel.errorCode} ${state.data.errorModel.message}",
    )
}
