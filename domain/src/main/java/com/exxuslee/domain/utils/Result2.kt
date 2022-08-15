package com.exxuslee.domain.utils

sealed class Result2 {

    abstract fun handle(handleResult: HandleResult)

    class Success(private val value: IntArray) : Result2() {
        override fun handle(handleResult: HandleResult) {
            handleResult.handleSuccess(value)
        }
    }

    class Error(private val message: String) : Result2() {
        override fun handle(handleResult: HandleResult) {
            handleResult.handleError(message)
        }
    }
}