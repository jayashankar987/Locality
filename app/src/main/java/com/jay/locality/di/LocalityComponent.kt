package com.jay.locality.di

import dagger.Component

@Component(modules = [LocalityModule::class])

interface LocalityComponent : AndroidInje {

    LoginModel loginModel ()
}