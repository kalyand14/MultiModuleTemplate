package com.android.multimoduletemplate.core.presentation

import androidx.lifecycle.ViewModel
import com.android.multimoduletemplate.navigation.LiveNavigationField
import com.android.multimoduletemplate.navigation.NavigationDestination
import com.android.multimoduletemplate.navigation.NavigationEvent

open class BaseViewModel : ViewModel() {
    /**
     * Live Data that handles passing Navigation Events
     */
    val navigationLiveDataField = LiveNavigationField<NavigationEvent>()

    /**
     * Helper function for navigating to the [destination] fragment from the current one
     */
    fun navigateTo(destination: NavigationDestination) {
        navigationLiveDataField.latestValue = destination.buildEvent()
    }
}