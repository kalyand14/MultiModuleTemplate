package com.android.multimoduletemplate.core

import android.app.Application
import com.android.multimoduletemplate.core.data.PreferenceHelper
import com.android.multimoduletemplate.core.session.UserManager
import kotlinx.coroutines.ExperimentalCoroutinesApi


class App : Application() {
    companion object {
        var prefs: PreferenceHelper? = null
        @ExperimentalCoroutinesApi
        var userManager: UserManager? = null
    }

    @ExperimentalCoroutinesApi
    override fun onCreate() {
        prefs = PreferenceHelper(this)
        userManager = UserManager(
            prefs!!)
        super.onCreate()
    }
}

