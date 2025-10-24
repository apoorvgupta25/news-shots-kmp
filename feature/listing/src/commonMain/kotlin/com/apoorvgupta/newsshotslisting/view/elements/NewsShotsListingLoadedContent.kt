package com.apoorvgupta.newsshotslisting.view.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.HeadLine
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshotslisting.intent.NewsShotsListingViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun NewsShotsListingLoadedContent(
    state: NewsShotsListingViewStates.LoadedData,
    userIntent: (NewsShotsListingIntent) -> Unit,
    newsShotsResults: LazyPagingItems<NewsShots>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.HorizonalDimensions.m_horizontal_spacing),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(Dimensions.VerticalDimensions.s_vertical_spacing))

        HeadLine(
            headText = state.data.headingText,
            onBackClick = {
                userIntent.invoke(NewsShotsListingIntent.NavigateToPreviousScreen)
            },
        )

        Spacer(modifier = Modifier.height(Dimensions.VerticalDimensions.s_vertical_spacing))

        LazyColumn {

            items(
                count = newsShotsResults.itemCount,
            ) { index ->
                newsShotsResults.get(index = index)?.let { newsShot ->
                    NewsShotsCard(
                        newsShot = newsShot,
                        onCardClick = {
                            userIntent.invoke(
                                NewsShotsListingIntent.NavigateToIndividualNewsShots(
                                    newsShot.link,
                                ),
                            )
                        },
                        onBookmarkClick = {},
                    )
                    if (newsShotsResults.itemCount - 1 != index) {
                        HorizontalDivider(
                            modifier = Modifier.padding(all = Dimensions.SurroundingDimensions.s_surrounding_spacing),
                        )
                    }
                }
            }
        }
    }
}
