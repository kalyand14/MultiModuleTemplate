package com.android.multimoduletemplate.login

import com.android.multimoduletemplate.core.presentation.BaseViewModel

class LoginViewModel(private val coordinator: LoginCoordinator) : BaseViewModel() {

    fun onLoginClick() {
        navigateTo(coordinator.finishDestination())
    }

}