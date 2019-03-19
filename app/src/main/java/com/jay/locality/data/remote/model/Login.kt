package com.jay.locality.data.remote.model

import com.google.gson.annotations.SerializedName

//Request
data class LoginRequest(
    @SerializedName("password")
    val password: String = "",
    @SerializedName("email")
    val email: String = ""
)

//Response
data class LoginResponse(
    @SerializedName("response_code")
    val responseCode: String = "",
    @SerializedName("reponse")
    val response: Response,
    @SerializedName("message")
    val message: String = ""
)

data class Response(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("auth_token")
    val authToken: String = ""
)