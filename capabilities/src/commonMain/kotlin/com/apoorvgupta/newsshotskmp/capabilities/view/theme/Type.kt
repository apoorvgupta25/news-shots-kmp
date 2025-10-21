package com.apoorvgupta.newsshotskmp.capabilities.view.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import newsshotskmp.capabilities.generated.resources.Res
import newsshotskmp.capabilities.generated.resources.graphik_medium
import newsshotskmp.capabilities.generated.resources.graphik_regular
import newsshotskmp.capabilities.generated.resources.poppins_medium
import newsshotskmp.capabilities.generated.resources.poppins_semi_bold
import newsshotskmp.capabilities.generated.resources.poppins_bold
import newsshotskmp.capabilities.generated.resources.poppins_regular
import newsshotskmp.capabilities.generated.resources.poppins_italic
import newsshotskmp.capabilities.generated.resources.newsreader_medium
import newsshotskmp.capabilities.generated.resources.newsreader_semi_bold
import newsshotskmp.capabilities.generated.resources.newsreader_bold
import newsshotskmp.capabilities.generated.resources.newsreader_regular
import newsshotskmp.capabilities.generated.resources.newsreader_italic
import org.jetbrains.compose.resources.Font

/**
 * Typography for defining text styles.
 *
 * @author Apoorv Gupta
 */

private val Poppins
    @Composable
    get() = FontFamily(
        Font(Res.font.poppins_medium, weight = FontWeight.Medium),
        Font(Res.font.poppins_semi_bold, weight = FontWeight.SemiBold),
        Font(Res.font.poppins_bold, weight = FontWeight.Bold),
        Font(Res.font.poppins_regular, weight = FontWeight.Normal),
        Font(Res.font.poppins_italic),
    )

val Graphik
    @Composable
    get() = FontFamily(
        Font(Res.font.graphik_medium, weight = FontWeight.Medium),
        Font(Res.font.graphik_regular, weight = FontWeight.Normal),
    )

private val NewsReader60
    @Composable
    get() = FontFamily(
        Font(Res.font.newsreader_medium, weight = FontWeight.Medium),
        Font(Res.font.newsreader_semi_bold, weight = FontWeight.SemiBold),
        Font(Res.font.newsreader_bold, weight = FontWeight.Bold),
        Font(Res.font.newsreader_regular, weight = FontWeight.Normal),
        Font(Res.font.newsreader_italic, style = FontStyle.Italic),
    )

private val AppFontFamily @Composable get() = NewsReader60

val AppTypography @Composable get() = Typography(
        displayLarge = Typography().displayLarge.copy(fontFamily = AppFontFamily),
        displayMedium = Typography().displayMedium.copy(fontFamily = AppFontFamily),
        displaySmall = Typography().displaySmall.copy(fontFamily = AppFontFamily),
        headlineLarge = Typography().headlineLarge.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
        ),
        headlineMedium = Typography().headlineMedium.copy(fontFamily = AppFontFamily),
        headlineSmall = Typography().headlineSmall.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        titleLarge = Typography().titleLarge.copy(fontFamily = AppFontFamily),
        titleMedium = Typography().titleMedium.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = Dimensions.TextSize.text_size_title_medium,
        ),
        titleSmall = Typography().titleSmall.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = Dimensions.TextSize.text_size_title_small,
        ),
        bodyLarge = Typography().bodyLarge.copy(fontFamily = AppFontFamily),
        bodyMedium = Typography().bodyMedium.copy(fontFamily = AppFontFamily),
        bodySmall = Typography().bodySmall.copy(fontFamily = AppFontFamily),
        labelLarge = Typography().labelLarge.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
        ),
        labelMedium = Typography().labelMedium.copy(fontFamily = AppFontFamily),
        labelSmall = Typography().labelSmall.copy(fontFamily = AppFontFamily),
    )