package com.apoorvgupta.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Composable function representing the overall theme of the app using Jetpack Compose.
 *
 * @param darkTheme Flag to indicate whether the theme is in dark mode or light mode.
 * @param content The content block to apply the theme to.
 *
 * @author Apoorv Gupta
 */
@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colors =
        if (!darkTheme) LightColorScheme else DarkColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = Shapes,
        content = content,
    )
}
