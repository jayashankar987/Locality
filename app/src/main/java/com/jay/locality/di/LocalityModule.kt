package com.jay.locality.di

import com.jay.locality.di.contract.ILoginPresenter
import com.jay.locality.model.LoginModel
import com.jay.locality.presenter.LoginPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalityModule {

    @Provides
    @Singleton
    fun providesLoginPresenter(loginModel: LoginModel): ILoginPresenter = LoginPresenter(loginModel)


}
