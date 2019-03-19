package com.jay.locality.data.remote

import com.jay.locality.data.remote.model.LoginRequest
import com.jay.locality.data.remote.model.LoginResponse
import com.jay.locality.data.remote.retrofit.NetworkApi
import io.reactivex.Single

class NetworkImpl(private val networkApi: NetworkApi) : Network {
    override fun doLogin(loginRequest: LoginRequest): Single<LoginResponse> =
        networkApi.doLogin(loginRequest)

}