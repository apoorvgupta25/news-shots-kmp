package com.apoorvgupta.newsshotskmp.capabilities.view.navigation.ui

import org.jetbrains.compose.resources.DrawableResource

data class BottomNavItem(
    val displayBadge: Boolean,
    val navigationRoute: Any,
    val position: Int,
    val title: String,
    val visible: Boolean,
    var badgeCount: Int,
    val unselectedIcon: DrawableResource,
    val selectedIcon: DrawableResource,
)
