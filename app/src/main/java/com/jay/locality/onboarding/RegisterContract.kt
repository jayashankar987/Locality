package com.jay.locality.onboarding

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.jay.commons.base.BasePresenter
import com.jay.commons.base.BaseState
import com.jay.commons.base.BaseView

class InputError(val errorType: InputErrorType) : Exception("Invalid Input Entry") {
    enum class InputErrorType {
        EMAIL_EMPTY_ERROR, PWD_EMPTY_ERROR, CONFIRM_PWD_EMPTY_ERROR, PWD_MISMATCH_ERROR
    }
}


interface IRegisterView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun onError(error: Throwable?)
    fun onInputError(inputError: InputError? = null)
    fun onSuccess()
}

interface IRegisterPresenter : BasePresenter<IRegisterView, RegisterState> {
    fun registerFormValidationAction(email: String, password: String, confirmPassword: String)
}


sealed class RegisterState : BaseState {

    data class RegisterFormState(
        val isLoading: Boolean = false,
        val error: Throwable? = null,
        val success: Task<AuthResult>? = null,
        val inputError: InputError? = null
    ) : RegisterState()
}