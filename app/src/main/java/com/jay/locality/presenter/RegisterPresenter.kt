package com.jay.locality.presenter

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class RegisterPresenter @Inject constructor(
    private val email: String,
    private val password: String, private val auth: FirebaseAuth
) {

}
