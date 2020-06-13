package com.android.multimoduletemplate.login

import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.navigation.NavigationOption

object LoginCoordinator {

    lateinit var finishCallback: () -> NavigationDestination

    fun startDestination(
        isLogout: Boolean = false,
        callback: () -> NavigationDestination
    ): NavigationDestination {
        finishCallback = callback
        return NavigationDestination(
            R.id.nav_login,
            navigationOption = NavigationOption(
                R.id.login_fragment,
                inclusive = true,
                isSingleTop = true,
                clearStack = isLogout
            )
        )
    }

    internal fun finishDestination(): NavigationDestination {
        return finishCallback()
    }
}