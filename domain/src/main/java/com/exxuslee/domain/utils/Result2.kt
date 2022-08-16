package com.exxuslee.domain.utils

sealed class Result2 {

    abstract fun<T> handle(handleResult: HandleResult<T>)

    class Success<T>(private val value: T) : Result2() {
        override fun <T> handle(handleResult: HandleResult<T>) {
            handleResult.handleSuccess(value)
        }
    }

    class Error(private val message: String) : Result2() {
        override fun <T> handle(handleResult: HandleResult<T>) {
            handleResult.handleError(message)
        }
    }
}