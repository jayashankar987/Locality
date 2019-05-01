package com.jay.locality

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.jay.locality.di.AppModule
import com.jay.locality.di.OnBoardingModule
import com.jay.locality.di.component.AppComponent
import com.jay.locality.di.component.DaggerAppComponent
import com.jay.locality.di.component.OnBoardingComponent
import com.jay.locality.utils.ReleaseTree
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class LocalityApp : Application() {

    companion object {
        val instance: LocalityApp by lazy {
            LocalityApp()
        }
    }

    val onboardingComponent: OnBoardingComponent by lazy {
        appComponent.newOnBoardingComponent(OnBoardingModule())
    }
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

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