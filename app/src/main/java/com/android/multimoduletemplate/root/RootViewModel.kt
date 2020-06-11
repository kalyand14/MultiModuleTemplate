package com.android.multimoduletemplate.root

import androidx.lifecycle.viewModelScope
import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.core.presentation.SingleLiveEvent
import com.android.multimoduletemplate.domain.session.AuthenticatedUser
import com.android.multimoduletemplate.domain.session.OnBoardingStatus
import com.android.multimoduletemplate.domain.session.UserManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RootViewModel(
    private val coordinator: RootCoordinator,
    private val userManager: UserManager? = UserManager()
) : BaseViewModel() {

    val loggedOutEvent = SingleLiveEvent<Void>()

    init {
        subscribeObserver()
    }

    fun subscribeObserver() {
        viewModelScope.launch {
            userManager?.user?.collect {
                when (it) {
                    is AuthenticatedUser -> {
                        when (it.onBoardingStatus) {
                            OnBoardingStatus.COMPLETED -> navigateTo(RootCoordinator.dashBoardStartDestination())
                            else -> navigateTo(RootCoordinator.onBoardingStartDestination())
                        }
                    }
                    else -> {
                        navigateTo(RootCoordinator.loginStartDestination())
                    }
                }
            }
        }

    }

    fun logout() {
        navigateTo(RootCoordinator.loginStartDestination())
    }


}