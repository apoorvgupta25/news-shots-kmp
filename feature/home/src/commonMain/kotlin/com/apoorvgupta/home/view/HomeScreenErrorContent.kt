package com.apoorvgupta.home.view

import androidx.compose.runtime.Composable
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.errorscreen.AppErrorScreen

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
