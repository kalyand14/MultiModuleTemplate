package com.android.multimoduletemplate.profile

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.core.session.UserManager

class ProfileViewModelFactory constructor(
    private val userManager: UserManager
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(userManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}