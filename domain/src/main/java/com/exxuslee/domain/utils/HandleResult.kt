package com.exxuslee.domain.utils

interface HandleResult {
    fun handleSuccess (data: IntArray)
    fun handleError (message: String)
}