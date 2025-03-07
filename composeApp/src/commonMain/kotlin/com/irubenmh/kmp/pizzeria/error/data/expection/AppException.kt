package com.irubenmh.kmp.pizzeria.error.data.expection

abstract class AppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)