package com.jay.locality.di

import com.google.firebase.auth.FirebaseAuth
import com.jay.locality.onboarding.IRegisterPresenter
import com.jay.locality.onboarding.presenter.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class OnBoardingModule {

    @Provides
    @OnBoardingScope
    fun providesRegisterPresenter(firebaseAuth: FirebaseAuth): IRegisterPresenter = RegisterPresenter(firebaseAuth)
}