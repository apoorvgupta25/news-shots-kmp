package com.apoorvgupta.designsystem.reusableComponents.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.designsystem.theme.Dimensions
import com.apoorvgupta.designsystem.theme.buttonTextStyle
import com.apoorvgupta.designsystem.theme.disabledBackgroundColor
import com.apoorvgupta.designsystem.theme.disabledTextColor

/**
 * Composable function to handle the Buttons through out the application
 *
 * @param modifier          - Modifier to define the width
 * @param buttonTitle       - Button title
 * @param isButtonFilled    - True if the button is filled, else false
 * @param fillColor         - Fill color / border color for unfilled buttons
 * @param textColor         - Text color
 * @param isEnabled         - True if button is enabled, else false
 * @param onClickListener   - Button click handler function
 */
@Composable
fun AppButton(
    modifier: Modifier,
    appButtonConfig: AppButtonConfig,
    fillColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(Dimensions.CornerRadius.sl_corner_radius),
        border =
        BorderStroke(
            Dimensions.StrokeWidth.xxxs_stroke_width,
            if (appButtonConfig.isEnabled.value) fillColor else MaterialTheme.colorScheme.disabledBackgroundColor,
        ),
        elevation = null,
        enabled = appButtonConfig.isEnabled.value,
        colors =
        if (appButtonConfig.isButtonFilled) {
            ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.disabledBackgroundColor,
                containerColor = fillColor,
                contentColor = textColor,
                disabledContentColor = MaterialTheme.colorScheme.disabledTextColor,
            )
        } else {
            ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        },
        onClick = appButtonConfig.onClickListener,
    ) {
        Spacer(Modifier.size(Dimensions.StrokeWidth.xxxs_stroke_width))
        Text(
            modifier = Modifier.padding(horizontal = Dimensions.HorizonalDimensions.xs_horizontal_spacing),
            text = appButtonConfig.buttonTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.buttonTextStyle.copy(color = textColor),
        )
    }
}

data class AppButtonConfig(
    val buttonTitle: String,
    val isButtonFilled: Boolean = true,
    val isEnabled: MutableState<Boolean> = mutableStateOf(true),
    val onClickListener: () -> Unit,
)
