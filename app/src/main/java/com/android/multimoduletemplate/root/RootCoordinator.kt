package com.android.multimoduletemplate.root

import com.android.multimoduletemplate.cardactivation.CardActivationCoordinator
import com.android.multimoduletemplate.core.App
import com.android.multimoduletemplate.dashboard.DashBoardCoordinator
import com.android.multimoduletemplate.login.LoginCoordinator
import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.onboarding.OnBoardingCoordinator


object RootCoordinator {

    private val loginCoordinator: LoginCoordinator = LoginCoordinator
    private val onBoardCoordinator: OnBoardingCoordinator = OnBoardingCoordinator
    private val dashBoardCoordinator: DashBoardCoordinator = DashBoardCoordinator
    private val cardActivationCoordinator: CardActivationCoordinator = CardActivationCoordinator

    fun loginStartDestination(isLogout: Boolean): NavigationDestination {
        return loginCoordinator.startDestination(isLogout, RootCoordinator::loginSuccessDestination)
    }

    private fun loginSuccessDestination(): NavigationDestination {
        return dashBoardStartDestination()
    }

    fun onBoardingStartDestination(): NavigationDestination {
        return onBoardCoordinator.startDestination(RootCoordinator::onBoardingCompleteDestination)
    }

    private fun onBoardingCompleteDestination(): NavigationDestination {
        return dashBoardStartDestination()
    }

    fun dashBoardStartDestination(): NavigationDestination {
        return ensureAuthenticatedAndThen { dashBoardCoordinator.startDestination() }
    }

    fun cardActivationStartDestination(callback: () -> NavigationDestination): NavigationDestination {
        return cardActivationCoordinator.startDestination {
            callback()
        }
    }

    private fun ensureAuthenticatedAndThen(
        func: () -> NavigationDestination
    ): NavigationDestination {
        return if (App.userManager?.isLoggedIn()!!) {
            func()
        } else {
            loginStartDestination(true)
        }
    }


}