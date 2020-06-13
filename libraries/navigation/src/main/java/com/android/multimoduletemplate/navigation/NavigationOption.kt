package com.android.multimoduletemplate.navigation

import androidx.annotation.IdRes

data class NavigationOption(
    @IdRes val destinationId: Int,
    val inclusive: Boolean = false,
    val isSingleTop: Boolean = false,
    val clearStack: Boolean = false
)