package com.jay.locality.presenter

import com.jay.locality.di.contract.ILoginPresenter
import com.jay.locality.model.LoginModel
import javax.inject.Inject

class LoginPresenter
@Inject constructor(loginModel: LoginModel) : ILoginPresenter