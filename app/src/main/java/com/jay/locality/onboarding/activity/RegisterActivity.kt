package com.jay.locality.onboarding.activity

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.jay.commons.base.BaseActivity
import com.jay.commons.extensions.toast
import com.jay.locality.LocalityApp
import com.jay.locality.MainActivity
import com.jay.locality.R
import com.jay.locality.onboarding.IRegisterPresenter
import com.jay.locality.onboarding.IRegisterView
import com.jay.locality.onboarding.InputError
import com.jay.locality.onboarding.RegisterState
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity<IRegisterView, RegisterState, IRegisterPresenter>(), IRegisterView {

    @Inject
    override lateinit var presenter: IRegisterPresenter

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalityApp.instance.onboardingComponent.inject(this)
        presenter.attachView(this)

        if (FirebaseAuth.getInstance().currentUser != null) {
            onSuccess()
        }

        register.setOnClickListener {
            val emailInput = email.text.toString()
            val passwordInput = password.text.toString()
            presenter.registerFormValidationAction(emailInput, passwordInput)
        }

        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun showProgressBar() {
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        //progressBar.visibility = View.GONE
    }

    override fun onInputError(inputError: InputError?) {
        hideProgressBar()
        when (inputError?.errorType) {
            InputError.InputErrorType.EMAIL_EMPTY_ERROR -> email.error = "Email is Empty"
            InputError.InputErrorType.PWD_EMPTY_ERROR -> password.error = "Password is Empty"
        }
    }

    override fun onError(error: Throwable?) {
        hideProgressBar()
        this toast error?.message
    }

    override fun onSuccess() {
        hideProgressBar()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this toast "Successfully Registered User"
        finishAffinity()
    }
}