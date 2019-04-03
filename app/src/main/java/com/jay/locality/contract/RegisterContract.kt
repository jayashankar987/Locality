package com.jay.locality.contract

import com.jay.locality.base.BasePresenter
import com.jay.locality.base.BaseView
import com.jay.locality.base.BaseViewState
import com.jay.locality.di.base.BaseState
import com.jay.locality.feature.register.CreateNewUserAction
import com.jay.locality.model.UserModel

interface IRegisterView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showRegisterSuccess()
    fun showRegisterFailed()
}

interface IRegisterPresenter: BasePresenter<IRegisterView, RegisterViewState> {
    fun registerNewUserState(createNewUserAction: CreateNewUserAction)
}


sealed class RegisterViewState : BaseViewState {
    data class RegisterSubmitState(
        val isLoading: Boolean,
        val userModel: UserModel? = null,
        val error: Throwable? = null
    ) : RegisterViewState()


    data class RegisterFormState(
        val isLoading: Boolean,
        val email: String = "", val password: String = ""
    ) : RegisterViewState()
}
