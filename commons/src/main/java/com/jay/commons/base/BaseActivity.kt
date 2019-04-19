package com.jay.commons.base

import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V : BaseView, S : BaseState, P : BasePresenter<V, S>> :
    AppCompatActivity() {

    @LayoutRes
    abstract fun layoutId(): Int
}