package com.jay.locality.utils

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber


class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        Crashlytics.log(priority, tag, message)

        if (throwable != null) {
            Crashlytics.logException(throwable)
        }
    }
}