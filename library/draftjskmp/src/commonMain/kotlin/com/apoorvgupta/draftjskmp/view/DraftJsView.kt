package com.apoorvgupta.draftjskmp.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.apoorvgupta.draftjskmp.data.DraftJS
import com.apoorvgupta.draftjskmp.utils.DraftJsUtils

/**
 * @author Apoorv Gupta
 */

@Composable
fun DraftJSView(
    modifier: Modifier = Modifier,
    draftJSContent: DraftJS,
    linkTextColor: Color = Color.Unspecified,
) {
    val content = remember(draftJSContent) {
        DraftJsUtils.parseDraftJsContent(draftJSContent, linkTextColor = linkTextColor)
    }

    Text(
        modifier = modifier,
        text = content,
    )
}
