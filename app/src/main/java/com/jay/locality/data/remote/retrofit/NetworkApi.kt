package com.jay.locality.data.remote.retrofit

import com.jay.locality.data.remote.model.LoginRequest
import com.jay.locality.data.remote.model.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkApi {
    companion object {
        const val FIREBASE_BASE_URL = ""
    }

    @POST("")
    fun doLogin(@Body request: LoginRequest): Single<LoginResponse>
}