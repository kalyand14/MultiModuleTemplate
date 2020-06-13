package com.android.multimoduletemplate.onboarding

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.core.session.UserManager

@Suppress("UNCHECKED_CAST")
class OnboardingViewModelFactory constructor(
    private val coordinator: OnBoardingCoordinator,
    private val userManager: UserManager
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnBoardingViewModel::class.java)) {
            return OnBoardingViewModel(coordinator, userManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}