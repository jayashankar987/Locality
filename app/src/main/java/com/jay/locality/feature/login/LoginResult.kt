package com.jay.locality.feature.login

import com.jay.locality.base.BaseResult

sealed class LoginResult : BaseResult {

    sealed class PerformLoginResult : LoginResult() {
        data class Success(val username: String) : PerformLoginResult()
        data class Failure(val error: String) : PerformLoginResult()
        object inProcess : PerformLoginResult()
    }

    sealed class LoadLoginResult : LoginResult() {
        data class Success(val welcome: String) : LoadLoginResult()
    }

    data class EnterEmailResult(val email: String) : LoginResult()
    data class EnterPasswordResult(val password: String) : LoginResult()
}