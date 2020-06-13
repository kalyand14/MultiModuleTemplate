package com.android.multimoduletemplate.core.session

sealed class User {
    object Idle : User()
    data class NotAuthenticated(val regStatus: RegStatus) : User()
    data class Authenticated(val username: String, val onBoardingStatus: OnBoardingStatus) :
        User()
    object LoggedOut: User()
}

sealed class UserEvent {
    data class Authenticate(val password: String) : UserEvent()
    object Logout : UserEvent()
    object UnRegister : UserEvent()

}