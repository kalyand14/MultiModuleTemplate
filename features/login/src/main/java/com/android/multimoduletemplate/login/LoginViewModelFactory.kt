package com.android.multimoduletemplate.login

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.domain.session.UserManager

class LoginViewModelFactory constructor(
    private val coordinator: LoginCoordinator
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(coordinator, UserManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}