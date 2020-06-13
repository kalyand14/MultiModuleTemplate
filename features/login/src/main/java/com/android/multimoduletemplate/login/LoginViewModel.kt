package com.android.multimoduletemplate.login

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.core.session.UserEvent
import com.android.multimoduletemplate.core.session.UserManager
import kotlinx.coroutines.ExperimentalCoroutinesApi

class LoginViewModel(private val coordinator: LoginCoordinator, val userManager: UserManager) : BaseViewModel() {

    @ExperimentalCoroutinesApi
    fun onLoginClick() {
        userManager.onEvent(UserEvent.Authenticate("11223"))
        //navigateTo(coordinator.finishDestination())
    }

}