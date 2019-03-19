package com.jay.locality.feature.login

import com.jay.locality.base.BaseIntent

sealed class LoginIntent : BaseIntent {
    object initialIntent : LoginIntent()
    data class PerformLoginIntent(val email: String, val password: String) : LoginIntent()
    data class EnterUserIdIntent(val email: String) : LoginIntent()
    data class EnterPasswordIntent(val password: String) : LoginIntent()
}