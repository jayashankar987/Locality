package com.jay.locality.feature.login

import com.jay.locality.base.BaseActionProcessor
import com.jay.locality.data.Repository
import com.jay.locality.data.remote.model.LoginRequest
import com.jay.locality.schedulers.BaseSchedulerProvider
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class LoginActionProcessor @Inject constructor(
    private val repository: Repository,
    private val scheduleProvider: BaseSchedulerProvider
) : BaseActionProcessor<LoginAction, LoginResult> {

    override fun transformFromAction(): ObservableTransformer<LoginAction, LoginResult> {
        return ObservableTransformer {
            it.publish { shared ->
                Observable.merge(
                    shared.ofType(LoginAction.LoadLoginAction::class.java).compose(loadLogin()),
                    shared.ofType(LoginAction.PerformLoginAction::class.java).compose(performLogin()),
                    shared.ofType(LoginAction.EnterUserIdAction::class.java).compose(enterUserId()),
                    shared.ofType(LoginAction.EnterPasswordAction::class.java).compose(enterPassword())
                )
            }
        }
    }

    private fun enterUserId(): ObservableTransformer<LoginAction.EnterUserIdAction, LoginResult.EnterEmailResult> {
        return ObservableTransformer {
            it.flatMap { Observable.just(LoginResult.EnterEmailResult(it.email)) }
        }
    }

    private fun performLogin(): ObservableTransformer<LoginAction.PerformLoginAction, LoginResult.PerformLoginResult> {
        return ObservableTransformer {
            it.flatMap {
                if (!it.email.isEmpty() && !it.password.isEmpty()) {
                    repository.performLogin(LoginRequest(password = it.password, email = it.email)).toObservable()
                        .map { LoginResult.PerformLoginResult.Success(it.response.name) }
                        .cast(LoginResult.PerformLoginResult::class.java)
                        .onErrorReturn { LoginResult.PerformLoginResult.Failure(it.localizedMessage) }
                        .subscribeOn(scheduleProvider.io())
                        .observeOn(scheduleProvider.ui())
                        .startWith(LoginResult.PerformLoginResult.inProcess)
                } else {
                    Observable.just(LoginResult.PerformLoginResult.Failure("email or password cannot be empty"))
                }
            }
        }
    }

    private fun enterPassword(): ObservableTransformer<LoginAction.EnterPasswordAction, LoginResult.EnterPasswordResult> {
        return ObservableTransformer {
            it.flatMap { Observable.just(LoginResult.EnterPasswordResult(it.password)) }
        }
    }
}


private fun loadLogin(): ObservableTransformer<LoginAction.LoadLoginAction, LoginResult.LoadLoginResult> {
    return ObservableTransformer {
        it.flatMap { Observable.just(LoginResult.LoadLoginResult.Success("Welcome")) }
    }
}