package com.android.multimoduletemplate.domain.session

sealed class User
object NotAuthenticated : User()
data class AuthenticatedUser(val username: String, val onBoardingStatus: OnBoardingStatus) : User()