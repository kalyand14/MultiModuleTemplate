package com.android.multimoduletemplate.root

import com.android.multimoduletemplate.dashboard.DashBoardCoordinator
import com.android.multimoduletemplate.core.session.UserManager
import com.android.multimoduletemplate.login.LoginCoordinator
import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.onboarding.OnBoardingCoordinator


object RootCoordinator {

    private val loginCoordinator: LoginCoordinator = LoginCoordinator
    private val onBoardCoordinator: OnBoardingCoordinator = OnBoardingCoordinator
    private val dashBoardCoordinator: DashBoardCoordinator = DashBoardCoordinator

    fun loginStartDestination(): NavigationDestination {
        return loginCoordinator.startDestination(RootCoordinator::loginSuccessDestination)
    }

    private fun loginSuccessDestination(): NavigationDestination {
        return dashBoardCoordinator.start()
    }

    fun onBoardingStartDestination(): NavigationDestination {
        return onBoardCoordinator.startDestination(RootCoordinator::onBoardingCompleteDestination)
    }

    private fun onBoardingCompleteDestination(): NavigationDestination {
        return dashBoardCoordinator.start()
    }

    fun dashBoardStartDestination(): NavigationDestination {
        return dashBoardCoordinator.start()
    }

    private fun ensureAuthenticatedAndThen(
        loggedIn: Boolean,
        func: () -> NavigationDestination
    ): NavigationDestination {
        return if (loggedIn) {
            func()
        } else {
            loginStartDestination()
        }
    }


}