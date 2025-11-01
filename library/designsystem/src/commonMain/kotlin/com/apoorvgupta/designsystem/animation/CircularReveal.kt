package com.apoorvgupta.designsystem.animation

import androidx.annotation.FloatRange
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.apoorvgupta.designsystem.Constants

// TODO
@Suppress("CognitiveComplexMethod", "NestedBlockDepth")
@Composable
fun <T> CircularReveal(
    targetState: T,
    modifier: Modifier = Modifier,
    animationSpec: FiniteAnimationSpec<Float> = tween(Constants.INT_1000),
    content: @Composable (T) -> Unit,
) {
    val items = remember { mutableStateListOf<CircularRevealAnimationItem<T>>() }
    val transitionState = remember { MutableTransitionState(targetState) }
    val targetChanged = targetState != transitionState.targetState
    var offset: Offset? by remember { mutableStateOf(null) }
    transitionState.targetState = targetState
    val transition = rememberTransition(transitionState, "transition")
    if (targetChanged || items.isEmpty()) {
        // Only manipulate the list when the state is changed, or in the first run.
        val keys = items.map { it.key }.run {
            if (!contains(targetState)) {
                toMutableList().apply { add(targetState) }
            } else {
                this
            }
        }
        items.clear()
        keys.mapIndexedTo(items) { index, key ->
            CircularRevealAnimationItem(key) {
                val progress by transition.animateFloat(
                    transitionSpec = { animationSpec },
                    label = "",
                ) {
                    if (index == keys.size - 1) {
                        if (it == key) 1f else 0f
                    } else {
                        1f
                    }
                }
                Box(Modifier.circularReveal(progress = progress, offset = offset)) {
                    content(key)
                }
            }
        }
    } else if (transitionState.currentState == transitionState.targetState) {
        // Remove all the intermediate items from the list once the animation is finished.
        items.removeAll { it.key != transitionState.targetState }
    }

    Box(
        modifier.pointerInput(Unit) {
            awaitEachGesture {
                val position = awaitFirstDown(requireUnconsumed = false).position
                offset = position
            }
        },
    ) {
        items.forEach {
            key(it.key) {
                it.content()
            }
        }
    }
}

private data class CircularRevealAnimationItem<T>(
    val key: T,
    val content: @Composable () -> Unit,
)

fun Modifier.circularReveal(
    @FloatRange(from = 0.0, to = 1.0) progress: Float,
    offset: Offset? = null
) = clip(CircularRevealShape(progress, offset))

@Suppress("UnnecessaryAnnotationUseSiteTarget", "UnnecessaryParentheses")
private class CircularRevealShape(
    @param:FloatRange(from = 0.0, to = 1.0) private val progress: Float,
    private val offset: Offset? = null,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline = Outline.Generic(
        Path().apply {
            val centerX = offset?.x ?: (size.width / Constants.FLOAT_2)
            val centerY = offset?.y ?: (size.height / Constants.FLOAT_2)
            val radius = size.width.coerceAtLeast(size.height) * 2 * progress

            // Create circle using Path in KMP
            addOval(
                Rect(
                    left = centerX - radius,
                    top = centerY - radius,
                    right = centerX + radius,
                    bottom = centerY + radius,
                ),
            )
        },
    )
}
