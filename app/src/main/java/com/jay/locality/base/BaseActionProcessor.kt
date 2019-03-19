package com.jay.locality.base

import io.reactivex.ObservableTransformer

interface BaseActionProcessor<I : BaseAction, R : BaseResult> {
    fun transformFromAction(): ObservableTransformer<I, R>
}