package com.android.multimoduletemplate.root

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.core.session.UserManager

@Suppress("UNCHECKED_CAST")
class RootViewModelFactory constructor(
    private val coordinator: RootCoordinator,
    private val userManager: UserManager
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RootViewModel::class.java)) {
            return RootViewModel(coordinator, userManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}