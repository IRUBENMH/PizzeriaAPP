package com.irubenmh.kmp.pizzeria.error.data.expection

abstract class AppConnectionException(
    message: String,
    cause: Throwable? = null
) : AppException(message, cause)