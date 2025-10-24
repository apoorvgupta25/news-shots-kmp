package com.apoorvgupta.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.home.view.elements.HomeHeaderSection
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.pulltorefresh.AppPullToRefresh
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun HomeScreenLoadedContent(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
    AppPullToRefresh(
        isRefreshing = state.showLoader,
        onRefresh = { userIntent.invoke(HomeIntent.LoadHomeScreen) },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    end = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    top = Dimensions.VerticalDimensions.m_vertical_spacing,
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            item {
                HomeHeaderSection(
                    state = state,
                    userIntent = userIntent,
                )
            }

            itemsIndexed(state.data.newsShotsList) { index, it ->
                NewsShotsCard(
                    newsShot = it,
                    onCardClick = {
                        userIntent.invoke(HomeIntent.NavigateToIndividualNewsShots(it.link))
                    },
                    onBookmarkClick = {},
                )

                if (state.data.newsShotsList.size - 1 != index) {
                    HorizontalDivider(
                        modifier = Modifier.padding(all = Dimensions.SurroundingDimensions.s_surrounding_spacing),
                    )
                }
            }
        }
    }
}
