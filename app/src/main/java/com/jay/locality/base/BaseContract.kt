package com.jay.locality.base

interface BasePresenter<V : BaseView, S : BaseViewState> {

    fun updateView(state: S)
}