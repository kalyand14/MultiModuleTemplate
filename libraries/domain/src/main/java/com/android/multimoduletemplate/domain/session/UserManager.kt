package com.android.multimoduletemplate.domain.session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserManager() {

    lateinit var user: Flow<User>

    init {
        user = flow {
            emit(NotAuthenticated)
        }.flowOn(Dispatchers.IO)
    }

    fun authenticate(passcode: String) {
        user = flow {
            emit(AuthenticatedUser("Kalyan", OnBoardingStatus.COMPLETED))
        }.flowOn(Dispatchers.IO)
    }

    fun logout() {
        user = flow {
            emit(NotAuthenticated)
        }.flowOn(Dispatchers.IO)
    }

    val regState: RegStatus =
        if (false) RegStatus.OLD else RegStatus.NEW

}