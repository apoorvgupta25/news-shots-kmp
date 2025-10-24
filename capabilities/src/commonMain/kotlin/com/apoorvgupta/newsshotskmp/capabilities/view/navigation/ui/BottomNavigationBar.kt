package com.apoorvgupta.newsshotskmp.capabilities.view.navigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.Destinations
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.shadowBackgroundColor
import newsshotskmp.capabilities.generated.resources.Res
import newsshotskmp.capabilities.generated.resources.ic_bookmark_selected
import newsshotskmp.capabilities.generated.resources.ic_bookmark_unselected
import newsshotskmp.capabilities.generated.resources.ic_home_selected
import newsshotskmp.capabilities.generated.resources.ic_home_unselected
import newsshotskmp.capabilities.generated.resources.ic_search_selected
import newsshotskmp.capabilities.generated.resources.ic_search_unselected
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

/**
 * Composable function representing the Bottom Navigation Bar in the app.
 *
 * This Bottom Navigation Bar provides navigation between Home, Profile, and Settings screens.
 *
 * @param navController The NavController used for navigation within the app.
 *
 * @author Apoorv Gupta
 */
@Composable
fun BottomNavigationBar(
    navController: NavController,
    bottomBarHeight: Dp,
    bottomBarOffsetHeightPx: MutableState<Float>,
) {
    // State variables to track the selected item and current route.
    var currentRoute by remember { mutableStateOf(Destinations.Home::class.simpleName) }

    val route = navController.currentBackStackEntryAsState().value?.destination?.route

    if (route != null) {
        currentRoute = route
    }

    val items = listOf(
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.Home,
            position = 0,
            title = "Home",
            visible = true,
            badgeCount = 0,
            unselectedIcon = Res.drawable.ic_home_unselected,
            selectedIcon = Res.drawable.ic_home_selected,
        ),
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.Search,
            position = 1,
            title = "Search",
            visible = true,
            badgeCount = 0,
            unselectedIcon = Res.drawable.ic_search_unselected,
            selectedIcon = Res.drawable.ic_search_selected,
        ),
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.Bookmark,
            position = 2,
            title = "Bookmark",
            visible = true,
            badgeCount = 0,
            unselectedIcon = Res.drawable.ic_bookmark_unselected,
            selectedIcon = Res.drawable.ic_bookmark_selected,
        ),
    )

    // Build the Bottom Navigation Bar using Jetpack Compose.
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .height(bottomBarHeight)
            .offset {
                IntOffset(
                    x = 0,
                    y = -bottomBarOffsetHeightPx.value.roundToInt(),
                )
            }
            .shadow(
                elevation = Dimensions.SurroundingDimensions.s_surrounding_spacing,
                spotColor = MaterialTheme.colorScheme.shadowBackgroundColor,
            ),
    ) {
        items.forEach { item ->
            val isCurrentRouteSelected = currentRoute?.substringAfterLast(".") == item.navigationRoute::class.simpleName

            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                    Image(
                        painter = painterResource(if (isCurrentRouteSelected) item.selectedIcon else item.unselectedIcon),
                        contentDescription = String.emptyValue(),
                        modifier = Modifier.size(Dimensions.IconSize.l_icon_size),
                        colorFilter = ColorFilter.tint(color = if (isCurrentRouteSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurface),
                    )
                    if (item.displayBadge) {
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
                                    Text(text = item.badgeCount.toString())
                                }
                            },
                        ) {
                        }
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (isCurrentRouteSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurface,
                    )
                },
                selected = isCurrentRouteSelected,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = MaterialTheme.colorScheme.background,
                ),
                onClick = {
                    navController.navigate(item.navigationRoute)
                },
            )
        }
    }
}
