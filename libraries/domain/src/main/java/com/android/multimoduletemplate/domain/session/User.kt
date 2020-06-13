package com.android.multimoduletemplate.domain.session

sealed class User {
    object Idle : User()
    data class NotAuthenticated(val regStatus: RegStatus) : User()
    data class Authenticated(val username: String, val onBoardingStatus: OnBoardingStatus) :
        User()
}

sealed class UserEvent {
    data class Authenticate(val password: String) : UserEvent()
    object Logout : UserEvent()
}