package com.apoorvgupta.newsshotskmp.capabilities.view.reusableComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.newsshotskmp.capabilities.Constants
import com.apoorvgupta.newsshotskmp.capabilities.view.theme.Dimensions
import newsshotskmp.capabilities.generated.resources.Res
import newsshotskmp.capabilities.generated.resources.ic_dark_mode
import newsshotskmp.capabilities.generated.resources.ic_light_mode
import newsshotskmp.capabilities.generated.resources.ic_system_dark_mode
import newsshotskmp.capabilities.generated.resources.ic_system_light_mode
import org.jetbrains.compose.resources.painterResource

/**
 * @author Apoorv Gupta
 */

@Composable
fun HeadLine(
    headText: String = String.emptyValue(),
    subHeadingText: String = String.emptyValue(),
    currentTheme: AppThemeOptions = AppThemeOptions.SYSTEM,
    onHeadClick: () -> Unit = {},
    onModeIconClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (onBackClick != null) {
            BackArrowNavigation(
                onBackClick = onBackClick,
            )

            Spacer(modifier = Modifier.width(Dimensions.HorizonalDimensions.m_horizontal_spacing))
        }

        // Title
        Text(
            text = headText,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = Dimensions.VerticalDimensions.sm_vertical_spacing)
                .noRippleClickable {
                    onHeadClick.invoke()
                },
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

        if (onModeIconClick != null) {
            Image(
                painter = painterResource(
                    when (currentTheme) {
                        AppThemeOptions.LIGHT -> Res.drawable.ic_light_mode
                        AppThemeOptions.DARK -> Res.drawable.ic_dark_mode
                        AppThemeOptions.SYSTEM -> if (isSystemInDarkTheme()) Res.drawable.ic_system_dark_mode else Res.drawable.ic_system_light_mode
                    },
                ),
                contentDescription = String.emptyValue(),
                modifier = Modifier
                    .size(Dimensions.IconSize.xml_icon_size)
                    .noRippleClickable {
                        onModeIconClick.invoke()
                    },
            )
        }
    }
    if (subHeadingText.isNotEmpty()) {
        // SubTitle
        Text(
            text = subHeadingText,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}
