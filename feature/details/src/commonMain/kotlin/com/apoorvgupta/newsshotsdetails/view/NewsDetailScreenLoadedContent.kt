package com.apoorvgupta.newsshotsdetails.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.apoorvgupta.draftjskmp.view.DraftJSView
import com.apoorvgupta.newsshotsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsshotsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsshotskmp.capabilities.Constants
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.BackArrowNavigation
import com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.pulltorefresh.AppPullToRefresh
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.linkTextColor

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailScreenLoadedContent(
    state: NewsDetailsViewStates.LoadedData,
    userIntent: (NewsDetailsIntent) -> Unit,
) {
    AppPullToRefresh(
        isRefreshing = state.showLoader,
        onRefresh = { userIntent.invoke(NewsDetailsIntent.RefreshNewsDetailsScreen) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            // Image
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    model = "${Constants.IMAGE_BASE_URL}${state.data.newsShot.link}",
                    contentDescription = "NewsShot image",
                )

                Column(
                    modifier = Modifier.padding(all = Dimensions.SurroundingDimensions.m_surrounding_spacing),
                ) {
                    BackArrowNavigation(
                        onBackClick = {
                            userIntent.invoke(NewsDetailsIntent.NavigateToPreviousScreen)
                        },
                    )
                }
            }

            // Desc
            Row(
                modifier = Modifier
                    .padding(
                        vertical = Dimensions.VerticalDimensions.m_vertical_spacing,
                        horizontal = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    )
                    .fillMaxWidth(),
            ) {
                Text(
                    text = state.data.newsShot.category.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

                Text(
                    text = state.data.newsShot.formattedDate,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }

            Text(
                modifier = Modifier.padding(
                    start = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    end = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    bottom = Dimensions.VerticalDimensions.m_vertical_spacing,
                ),
                text = state.data.newsShot.title,
                style = MaterialTheme.typography.headlineSmall,
            )

            // Main Content
            Box(
                modifier = Modifier.padding(horizontal = Dimensions.HorizonalDimensions.m_horizontal_spacing),
            ) {
                DraftJSView(
                    modifier = Modifier,
                    draftJSContent = state.data.newsShot.draftJSContent,
                    linkTextColor = MaterialTheme.colorScheme.linkTextColor,
                )
            }
        }
    }
}
