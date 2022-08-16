package com.exxuslee.domain.utils

sealed class Result2 {

    abstract fun<T> handle(handleResult: HandleResult<T>)

    class Success<out T>(private val value: T) : Result2() {
        override fun <T> handle(handleResult: HandleResult<T>) {
            handleResult.handleSuccess(value as T)
        }
    }

    class Error(private val message: String) : Result2() {
        override fun <T> handle(handleResult: HandleResult<T>) {
            handleResult.handleError(message)
        }
    }
}