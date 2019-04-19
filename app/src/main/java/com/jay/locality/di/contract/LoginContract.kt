package com.jay.locality.di.contract

import com.jay.commons.base.BasePresenter
import com.jay.commons.base.BaseState
import com.jay.commons.base.BaseView

interface ILoginView : com.jay.commons.base.BaseView {
    fun showProgress()
    fun hideProgress()
    fun loginSuccess()
    fun loginFailed()
}

interface ILoginPresenter : com.jay.commons.base.BasePresenter<ILoginView, LoginState> {
    fun doLogin()
}

sealed class LoginState : com.jay.commons.base.BaseState {
    data class userLoginState(val isLoading: Boolean = false)
}