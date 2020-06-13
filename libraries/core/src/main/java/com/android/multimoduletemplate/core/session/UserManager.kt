package com.android.multimoduletemplate.core.session

import com.android.multimoduletemplate.core.data.PreferenceHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class UserManager(private val preferenceHelper: PreferenceHelper) :
    CoroutineScope by CoroutineScope(Dispatchers.Default) {

    companion object {
        const val KEY_REGISTERED = "key_registered"
    }

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

    fun createRegistration() {
        preferenceHelper.save(KEY_REGISTERED, true)
    }

    private fun deleteRegistration() {
        preferenceHelper.clearSharedPreference()
        _userState.value = User.NotAuthenticated(RegStatus.NEW)
    }

    private fun hasFoundRegistrationData(): Boolean {
        return preferenceHelper.getValueBoolean(KEY_REGISTERED, false)
    }

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.Authenticate -> authenticate(event.password)
            is UserEvent.Logout -> logout()
            is UserEvent.UnRegister -> deleteRegistration()
        }
    }

}