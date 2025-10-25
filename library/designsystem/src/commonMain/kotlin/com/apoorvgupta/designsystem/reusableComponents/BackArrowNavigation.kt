package com.apoorvgupta.designsystem.reusableComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.apoorvgupta.designsystem.theme.Dimensions
import newsshotskmp.library.designsystem.generated.resources.Res
import newsshotskmp.library.designsystem.generated.resources.ic_back_arrow
import org.jetbrains.compose.resources.painterResource

/**
 * @author Apoorv Gupta
 */

@Composable
fun BackArrowNavigation(onBackClick: () -> Unit) {
    Image(
        painter = painterResource(resource = Res.drawable.ic_back_arrow),
        contentDescription = "Back",
        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.Companion
            .noRippleClickable {
                onBackClick()
            }
            .size(Dimensions.IconSize.xxl_icon_size)
            .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
            .border(
                border = BorderStroke(
                    width = Dimensions.StrokeWidth.xxxs_stroke_width,
                    color = MaterialTheme.colorScheme.outline,
                ),
                shape = CircleShape,
            )
            .padding(Dimensions.SurroundingDimensions.sm_surrounding_spacing),

    )
}
