package com.android.multimoduletemplate.onboarding

import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.navigation.NavigationOption

object OnBoardingCoordinator {
    lateinit var finishCallback: () -> NavigationDestination

    fun startDestination(callback: () -> NavigationDestination): NavigationDestination {
        finishCallback = callback
        return NavigationDestination(
            R.id.nav_onboarding,
            navigationOption = NavigationOption(
                R.id.onboarding_landing_fragment,
                inclusive = true,
                isSingleTop = true,
                clearStack = true
            )
        )
    }

    internal fun finishDestination(): NavigationDestination {
        return finishCallback()
    }

}