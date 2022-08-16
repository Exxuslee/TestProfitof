package com.exxuslee.domain.utils

interface HandleResult<T> {
    fun handleSuccess (data: Any?)
    fun handleError (message: String)
}