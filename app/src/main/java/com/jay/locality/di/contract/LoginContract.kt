package com.jay.locality.di.contract

import com.jay.locality.di.base.BasePresenter
import com.jay.locality.di.base.BaseState
import com.jay.locality.di.base.BaseView

interface ILoginView : BaseView {
    fun showProgress()
    fun hideProgress()
}

interface ILoginPresenter : BasePresenter<ILoginView, LoginState> {
    fun doLogin()
}

sealed class LoginState : BaseState {
    data class userLoginState(val isLoading: Boolean = false)
}