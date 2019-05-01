package com.jay.locality.onboarding.presenter

import com.google.firebase.auth.FirebaseAuth
import com.jay.locality.onboarding.IRegisterPresenter
import com.jay.locality.onboarding.IRegisterView
import com.jay.locality.onboarding.InputError
import com.jay.locality.onboarding.RegisterState
import javax.inject.Inject
import kotlin.properties.Delegates

class RegisterPresenter
@Inject constructor(private val firebaseAuth: FirebaseAuth) : IRegisterPresenter {


    override var view: IRegisterView? = null

    private var registerFormState: RegisterState.RegisterFormState by Delegates.observable(RegisterState.RegisterFormState()) { _, oldValue, newValue ->
        if (oldValue != newValue) updateView(newValue)
    }


    override fun registerFormValidationAction(email: String, password: String, confirmPassword: String) {

        var valid = true
        if (registerFormState.isLoading) {
            return
        }
        registerFormState = registerFormState.copy(isLoading = true, error = null, inputError = null)

        if (email.isEmpty()) {
            valid = false
            registerFormState = registerFormState.copy(
                isLoading = false,
                inputError = InputError(InputError.InputErrorType.EMAIL_EMPTY_ERROR)
            )
        }

        if (password.isEmpty()) {
            valid = false
            registerFormState =
                registerFormState.copy(
                    isLoading = false,
                    inputError = InputError(InputError.InputErrorType.PWD_EMPTY_ERROR)
                )
        }

        if (confirmPassword.isEmpty()) {
            valid = false
            registerFormState = registerFormState.copy(
                isLoading = false,
                inputError = InputError(InputError.InputErrorType.CONFIRM_PWD_EMPTY_ERROR)
            )
        }

        if (password != confirmPassword) {
            valid = false
            registerFormState = registerFormState.copy(
                isLoading = false,
                inputError = InputError(InputError.InputErrorType.PWD_MISMATCH_ERROR)
            )
        }

        if (valid) {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                registerFormState = if (it.isSuccessful) {
                    registerFormState.copy(isLoading = false, success = it)
                } else {
                    registerFormState.copy(isLoading = false, error = it.exception)
                }
            }
        }


    }

    override fun updateView(state: RegisterState) {
        when (state) {
            is RegisterState.RegisterFormState -> {
                when {
                    state.isLoading -> view?.showProgressBar()
                    state.inputError != null -> view?.onInputError(state.inputError)
                    state.error != null -> view?.onError(state.error)
                    state.success != null -> view?.onSuccess()
                }
            }
        }
    }
}