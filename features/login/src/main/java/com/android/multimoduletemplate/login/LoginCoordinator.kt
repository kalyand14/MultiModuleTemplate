package com.android.multimoduletemplate.login

import com.android.multimoduletemplate.navigation.NavigationDestination

object LoginCoordinator {

    lateinit var finishCallback: () -> NavigationDestination

    fun startDestination(callback: () -> NavigationDestination): NavigationDestination {
        finishCallback = callback
        return NavigationDestination(R.id.nav_login)
    }

    internal fun finishDestination(): NavigationDestination {
        return finishCallback()
    }
}