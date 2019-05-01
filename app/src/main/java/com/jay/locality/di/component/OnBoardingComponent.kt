package com.jay.locality.di.component

import com.jay.locality.di.OnBoardingModule
import com.jay.locality.di.OnBoardingScope
import com.jay.locality.onboarding.activity.RegisterActivity
import dagger.Subcomponent

@OnBoardingScope
@Subcomponent(modules = [OnBoardingModule::class])
interface OnBoardingComponent {
    fun inject(registerActivity: RegisterActivity)
}
