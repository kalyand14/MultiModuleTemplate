package com.android.multimoduletemplate.onboarding

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.core.session.UserManager
import com.android.multimoduletemplate.navigation.NavigationDestination
import kotlinx.coroutines.ExperimentalCoroutinesApi

class OnBoardingViewModel @ExperimentalCoroutinesApi constructor(
    private val coordinator: OnBoardingCoordinator,
    private val userManager: UserManager
) : BaseViewModel() {

    fun onLandingComplete() {
        navigateTo(NavigationDestination(R.id.onboarding_complete_fragment))
    }

    @ExperimentalCoroutinesApi
    fun onBoardingCompleted() {
        userManager.createRegistration()
        navigateTo(coordinator.finishDestination())
    }

}