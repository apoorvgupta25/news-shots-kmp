package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.designsystem.Constants
import com.apoorvgupta.designsystem.reusableComponents.HeadLine
import com.apoorvgupta.designsystem.theme.Dimensions

/**
 * @author Apoorv Gupta
 */
@Composable
fun HomeHeaderSection(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
    Column {
        // Headline
        HeadLine(
            headText = state.data.homeContent.headingText,
            subHeadingText = state.data.homeContent.subHeadingText,
            currentTheme = state.data.currentTheme,
            onHeadClick = {
                userIntent.invoke(HomeIntent.NavigateToNewsShotsListing(Constants.DAILY))
            },
            onModeIconClick = {
                userIntent.invoke(HomeIntent.ToggleAppTheme)
            },
        )

        // Category Chips
        CategoryChips(
            state = state,
            userIntent = userIntent,
        )

        // Divider
        HorizontalDivider(
            modifier = Modifier.padding(top = Dimensions.VerticalDimensions.m_vertical_spacing),
        )

        // Articles
        ArticlesLabel(
            state = state,
        )
    }
}
