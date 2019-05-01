package com.jay.commons.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V : BaseView, S : BaseState, P : BasePresenter<V, S>> :
    AppCompatActivity() {

    abstract val presenter: P

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }
}