package com.jay.locality.feature.login

import com.jay.locality.base.BaseAction

sealed class LoginAction : BaseAction {

    object LoadLoginAction : LoginAction()
    data class PerformLoginAction(val email: String, val password: String) : LoginAction()
    data class EnterUserIdAction(val email: String) : LoginAction()
    data class EnterPasswordAction(val password: String) : LoginAction()
}