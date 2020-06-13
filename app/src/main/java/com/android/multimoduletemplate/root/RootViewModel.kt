package com.android.multimoduletemplate.root

import androidx.lifecycle.viewModelScope
import com.android.multimoduletemplate.core.presentation.BaseViewModel
import com.android.multimoduletemplate.core.presentation.SingleLiveEvent
import com.android.multimoduletemplate.core.session.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalCoroutinesApi
class RootViewModel constructor(
    private val coordinator: RootCoordinator,
    private val userManager: UserManager
) : BaseViewModel() {

    val loggedOutEvent = SingleLiveEvent<Void>()

    init {
        subscribeObserver()
    }

    fun subscribeObserver() {
        userManager.userState.onEach {
            when (it) {
                is User.Authenticated -> {
                    navigateTo(
                        when (it.onBoardingStatus) {
                            OnBoardingStatus.COMPLETED -> RootCoordinator.dashBoardStartDestination()
                            else -> RootCoordinator.onBoardingStartDestination()
                        }
                    )
                }
                is User.NotAuthenticated -> {
                    navigateTo(
                        when (it.regStatus) {
                            RegStatus.OLD -> RootCoordinator.loginStartDestination()
                            RegStatus.NEW -> RootCoordinator.onBoardingStartDestination()
                        }
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun logout() {
        userManager.onEvent(UserEvent.Logout)
    }


}