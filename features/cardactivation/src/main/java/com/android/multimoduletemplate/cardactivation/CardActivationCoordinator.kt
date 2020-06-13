package com.android.multimoduletemplate.cardactivation

import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.navigation.NavigationOption

object CardActivationCoordinator {
    lateinit var finishCallback: () -> NavigationDestination

    fun startDestination(callback: () -> NavigationDestination): NavigationDestination {
        finishCallback = callback
        return NavigationDestination(
            R.id.nav_card_activation,
            navigationOption = NavigationOption(R.id.cardActivationStep1Fragment, false)
        )
    }

    internal fun finishDestination(): NavigationDestination {
        return finishCallback()
    }

}