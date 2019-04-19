package com.jay.locality.onboarding

import com.jay.commons.base.BasePresenter
import com.jay.commons.base.BaseState
import com.jay.commons.base.BaseView

interface IRegisterView: BaseView {
    fun showProgressBar()
    fun hideProgressBar()
}

interface IRegisterPresenter: BasePresenter<IRegisterView, IRegisterState> {
    fun performRegistration()
}


sealed class IRegisterState: BaseState {

}