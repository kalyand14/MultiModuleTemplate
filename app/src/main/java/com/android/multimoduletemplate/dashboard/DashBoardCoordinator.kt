package com.android.multimoduletemplate.dashboard

import com.android.multimoduletemplate.R
import com.android.multimoduletemplate.navigation.NavigationDestination

object DashBoardCoordinator {
    fun start(): NavigationDestination {
        return NavigationDestination(R.id.dashboard_fragment)
    }
}