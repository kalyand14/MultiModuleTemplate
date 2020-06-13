package com.android.multimoduletemplate.domain.session

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
object UserManager : CoroutineScope by CoroutineScope(Dispatchers.Default){

    private val regState: RegStatus by lazy { if (hasFoundRegistrationData()) RegStatus.OLD else RegStatus.NEW }

    private var _userState = MutableStateFlow<User>(User.Idle)

    var userState: StateFlow<User> = _userState

    init {
        _userState.value = User.NotAuthenticated(regState)
    }

    private fun authenticate(passcode: String) {
        // TODO need to hit repo and get the status
        _userState.value = User.Authenticated("Kalyan", OnBoardingStatus.COMPLETED)
    }

    private fun logout() {
        _userState.value = User.NotAuthenticated(RegStatus.OLD)
    }

    private fun hasFoundRegistrationData(): Boolean {
        // TODO - need to read from sharedpreference
        return true
    }

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.Authenticate -> authenticate(event.password)
            is UserEvent.Logout -> logout()
        }
    }

}