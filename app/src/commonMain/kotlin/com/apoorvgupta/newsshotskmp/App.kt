package com.apoorvgupta.newsshotskmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.compose.rememberNavController
import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.showNavigationBottomBar
import com.apoorvgupta.newsshotskmp.capabilities.view.navigation.ui.BottomNavigationBar
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.AppTheme
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import com.apoorvgupta.newsshotskmp.ui.NavigationHost
import org.koin.compose.koinInject

@Composable
fun App() {
    AppTheme(darkTheme = rememberIsDarkTheme()) {
        val navController = rememberNavController()

        val bottomBarHeight = remember { Dimensions.VerticalDimensions.xl8_vertical_spacing }
        val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
        val bottomBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }
        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    val delta = available.y
                    val newOffset = bottomBarOffsetHeightPx.floatValue + delta
                    bottomBarOffsetHeightPx.floatValue = newOffset.coerceIn(-bottomBarHeightPx, 0f)

                    return Offset.Zero
                }
            }
        }

        Scaffold(
            modifier = Modifier.nestedScroll(nestedScrollConnection),
            topBar = {
            },
            bottomBar = {
                // Display the BottomAppBar with BottomNavigationBar if specified for route
                if (showNavigationBottomBar(navController = navController)) {
                    BottomNavigationBar(
                        navController = navController,
                        bottomBarHeight = bottomBarHeight,
                        bottomBarOffsetHeightPx = bottomBarOffsetHeightPx,
                    )
                }
            },
        ) {
            // Include the NavigationHost composable within the Box
            NavigationHost(
                navController = navController,
                paddingTop = it.calculateTopPadding(),
            )
        }
    }
}

@Composable
private fun rememberIsDarkTheme(viewModel: AppViewModel = koinInject()): Boolean {
    val isSystemDarkTheme = isSystemInDarkTheme()

    val theme by remember(viewModel) {
        viewModel.loadCurrentTheme()
    }.collectAsState(initial = AppThemeOptions.SYSTEM)

    val isDarkTheme = when (theme) {
        AppThemeOptions.LIGHT -> false
        AppThemeOptions.DARK -> true
        AppThemeOptions.SYSTEM -> isSystemDarkTheme
    }
    return isDarkTheme
}
