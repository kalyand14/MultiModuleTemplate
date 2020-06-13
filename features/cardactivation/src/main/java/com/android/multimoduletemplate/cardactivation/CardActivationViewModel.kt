package com.android.multimoduletemplate.cardactivation

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.navigation.NavigationDestination
import kotlinx.coroutines.ExperimentalCoroutinesApi

class CardActivationViewModel @ExperimentalCoroutinesApi constructor(
    private val coordinator: CardActivationCoordinator
) : BaseViewModel() {

    fun onStep1Complete() {
        navigateTo(NavigationDestination(R.id.cardActivationStep2Fragment))
    }

    fun onStep2Complete() {
        navigateTo(NavigationDestination(R.id.cardActivationStep3Fragment))
    }

    fun onStep3Complete() {
        navigateTo(NavigationDestination(R.id.cardActivationStep4Fragment))
    }

    fun onStep4Complete() {
        navigateTo(NavigationDestination(R.id.cardActivationStep5Fragment))
    }

    fun onStep5Complete() {
        navigateTo(coordinator.finishDestination())
    }

}