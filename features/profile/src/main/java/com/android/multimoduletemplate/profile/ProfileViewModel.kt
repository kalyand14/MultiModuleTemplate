package com.android.multimoduletemplate.profile

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.core.session.UserEvent
import com.android.multimoduletemplate.core.session.UserManager
import kotlinx.coroutines.ExperimentalCoroutinesApi

class ProfileViewModel( val userManager: UserManager) : BaseViewModel() {

    @ExperimentalCoroutinesApi
    fun onClearRegistrationClick() {
        userManager.onEvent(UserEvent.UnRegister)
    }

}