package com.jay.locality.data.remote

import com.jay.locality.data.remote.model.LoginRequest
import com.jay.locality.data.remote.model.LoginResponse
import io.reactivex.Single

interface Network {
    fun doLogin(loginRequest: LoginRequest): Single<LoginResponse>
}