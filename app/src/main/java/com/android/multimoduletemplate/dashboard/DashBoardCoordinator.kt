package com.android.multimoduletemplate.dashboard

import com.android.multimoduletemplate.R
import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.navigation.NavigationOption

object DashBoardCoordinator {
    fun startDestination(): NavigationDestination {
        return NavigationDestination(
            R.id.dashboard_fragment,
            navigationOption = NavigationOption(
                R.id.dashboard_fragment, inclusive = true, isSingleTop = true
            )
        )
    }
}