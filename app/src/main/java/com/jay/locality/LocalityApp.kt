package com.jay.locality

import android.app.Application
import io.fabric.sdk.android.Fabric
import com.crashlytics.android.core.CrashlyticsCore
import com.crashlytics.android.Crashlytics
import com.jay.locality.utils.ReleaseTree
import timber.log.Timber



class LocalityApp : Application() {
    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.LOGS_ENABLED) {
            Timber.plant(Timber.DebugTree())
        }*/

        if (!BuildConfig.DEBUG) { // Crashlytics logs enabled for staging.
            Timber.plant(ReleaseTree())
            Fabric.with(this, Crashlytics())
        } else {
            // Manullay disabling crashlytics for Debug build as ext.enableCrashlytics=false is
            // not working with initWith() in groovy due to io.fabric.sdk.android.services
            // .concurrency.UnmetDependencyException issue from crashlytics in debug buildType
            val crashlytics = Crashlytics.Builder().core(
                CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()
            ).build()
            Fabric.with(this, crashlytics)
        }
    }
}