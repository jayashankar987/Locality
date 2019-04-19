package com.jay.commons.base

interface BaseState
interface BaseView

interface BasePresenter<V : BaseView, S : BaseState> {
    var view: V?

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun updateState(state: S)
}