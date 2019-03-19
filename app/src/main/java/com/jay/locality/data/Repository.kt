package com.jay.locality.data

import com.jay.locality.data.remote.model.LoginRequest
import com.jay.locality.data.remote.model.LoginResponse
import io.reactivex.Single

interface Repository {
    fun performLogin(loginRequest: LoginRequest): Single<LoginResponse>
}