package com.android.multimoduletemplate.login

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.core.session.UserManager

class LoginViewModelFactory constructor(
    private val coordinator: LoginCoordinator,
    private val userManager: UserManager
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(coordinator, userManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}