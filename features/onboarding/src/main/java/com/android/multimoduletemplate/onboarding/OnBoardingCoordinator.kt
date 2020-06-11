package com.android.multimoduletemplate.onboarding

import com.android.multimoduletemplate.navigation.NavigationDestination

object OnBoardingCoordinator {
    lateinit var finishCallback: () -> NavigationDestination

    fun startDestination(callback: () -> NavigationDestination): NavigationDestination {
        finishCallback = callback
        return NavigationDestination(R.id.nav_onboarding)
    }

    internal fun finishDestination(): NavigationDestination {
        return finishCallback()
    }

}