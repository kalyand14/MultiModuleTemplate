package com.android.multimoduletemplate.core.presentation

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.android.multimoduletemplate.navigation.LiveNavigationField
import com.android.multimoduletemplate.navigation.NavigationEvent


abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    /**
     * Sets up the fragment to listen for navigation events from [navigationLiveDataField]
     */
    protected fun setNavigationListener(navigationLiveDataField: LiveNavigationField<NavigationEvent>) {
        navigationLiveDataField.observe(viewLifecycleOwner, Observer { navigate(it) })
    }

    private fun navigate(event: NavigationEvent) {
        val navOptions = event.navigationOption?.let {
            NavOptions.Builder().setPopUpTo(
                it.destinationId,
                it.inclusive
            ).setLaunchSingleTop(it.isSingleTop)
                .build()
        }
        findNavController().navigate(event.navId, event.navigationArguments, navOptions)
    }
}