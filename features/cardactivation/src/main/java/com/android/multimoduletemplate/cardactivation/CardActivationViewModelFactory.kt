package com.android.multimoduletemplate.cardactivation

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.multimoduletemplate.core.session.UserManager

@Suppress("UNCHECKED_CAST")
class CardActivationViewModelFactory constructor(
    private val coordinator: CardActivationCoordinator
) : ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardActivationViewModel::class.java)) {
            return CardActivationViewModel(coordinator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}