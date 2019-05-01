package com.jay.locality.di.component

import com.jay.locality.di.AppModule
import com.jay.locality.di.OnBoardingModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class])

interface AppComponent {
/*
    @Component.Builder
    interface Builder {
        fun application(application: L): Builder
        fun build(): AppComponent
    }*/

    fun newOnBoardingComponent(onBoardingModule: OnBoardingModule): OnBoardingComponent
}