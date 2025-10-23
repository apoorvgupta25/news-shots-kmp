package com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions

/**
 * Composable function that displays a circular progress bar component.
 *
 * @param visibility Determines whether the circular progress bar should be visible.
 *
 * @author Apoorv Gupta
 */
@Composable
fun CircularProgressBarComponent(visibility: Boolean) {
    if (visibility) {
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
            content = {
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary,
                        strokeWidth = Dimensions.StrokeWidth.xs_stroke_width,
                    )
                }
            },
        )
    }
}
