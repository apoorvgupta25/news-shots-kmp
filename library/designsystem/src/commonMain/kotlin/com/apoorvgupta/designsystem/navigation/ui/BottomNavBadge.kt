package com.apoorvgupta.designsystem.navigation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.apoorvgupta.designsystem.theme.Dimensions

/**
 * @author Apoorv Gupta
 */

@Composable
fun BottomNavBadge(isCurrentRouteSelected: Boolean, bottomNavItem: BottomNavItem) {
    if (bottomNavItem.displayBadge) {
        BadgedBox(
            modifier = Modifier
                .padding(
                    top = Dimensions.VerticalDimensions.sl_vertical_spacing,
                    start = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    end = Dimensions.HorizonalDimensions.sl_horizontal_spacing,
                    bottom = Dimensions.VerticalDimensions.sl_vertical_spacing,
                ),
            badge = {
                Badge(
                    containerColor = if (isCurrentRouteSelected) MaterialTheme.colorScheme.primary else Color.Red,
                    contentColor = MaterialTheme.colorScheme.background,
                    modifier = Modifier.border(
                        width = Dimensions.StrokeWidth.xxxs_stroke_width,
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.background,
                    ),
                ) {
                    Text(text = bottomNavItem.badgeCount.toString())
                }
            },
        ) {
        }
    }
}
