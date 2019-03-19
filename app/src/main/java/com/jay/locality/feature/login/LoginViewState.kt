package com.jay.locality.feature.login

import com.jay.locality.base.BaseViewState

data class LoginViewState(
    val isLoading: Boolean,
    val email: String,
    val password: String,
    val isError: Boolean,
    val errorMessage: String,
    val isLoginSuccess: Boolean
) : BaseViewState {


    companion object {
        fun init(): LoginViewState {
            return LoginViewState(
                isLoading = false,
                email = "",
                password = "",
                isError = false,
                errorMessage = "",
                isLoginSuccess = false
            )
        }
    }
}