package com.android.multimoduletemplate.dashboard

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.root.RootCoordinator

@Suppress("UNCHECKED_CAST")
class DashBoardViewModelFactory constructor(
    private val coordinator: RootCoordinator
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardViewModel::class.java)) {
            return DashBoardViewModel(coordinator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}