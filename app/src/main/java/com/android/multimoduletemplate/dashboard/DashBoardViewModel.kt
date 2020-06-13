package com.android.multimoduletemplate.dashboard

import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.root.RootCoordinator
import kotlinx.coroutines.ExperimentalCoroutinesApi

class DashBoardViewModel @ExperimentalCoroutinesApi constructor(
    private val rootCoordinator: RootCoordinator
) : BaseViewModel() {
    fun activateCard() {
        navigateTo(rootCoordinator.cardActivationStartDestination {
            rootCoordinator.dashBoardStartDestination()
        })
    }
}