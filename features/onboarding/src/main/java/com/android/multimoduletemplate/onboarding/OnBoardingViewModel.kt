package com.android.multimoduletemplate.onboarding

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.navigation.NavigationDestination

class OnBoardingViewModel(
    private val coordinator: OnBoardingCoordinator
) : BaseViewModel() {

    fun onLandingComplete() {
        navigateTo(NavigationDestination(R.id.onboarding_complete_fragment))
    }

    fun onBoardingCompleted() {
        navigateTo(coordinator.finishDestination())
    }

}