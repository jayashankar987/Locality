package com.jay.locality.onboarding.presenter

import com.jay.locality.onboarding.IRegisterPresenter
import com.jay.locality.onboarding.IRegisterState
import com.jay.locality.onboarding.IRegisterView
import javax.inject.Inject

class RegisterPresenter
@Inject constructor(): IRegisterPresenter {
    override fun performRegistration() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var view: IRegisterView? = null

    override fun updateState(state: IRegisterState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}