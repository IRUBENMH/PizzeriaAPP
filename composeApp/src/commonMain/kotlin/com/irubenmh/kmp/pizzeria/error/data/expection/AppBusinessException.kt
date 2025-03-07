package com.irubenmh.kmp.pizzeria.error.data.expection

open class AppBusinessException : AppException {


    val code: String?


    constructor(message: String) : super(message) {
        this.code = null
    }

    constructor(message: String, cause: Throwable? = null) : super(message, cause) {
        this.code = null
    }

    constructor(code: String?, message: String, cause: Throwable? = null) : super(message, cause) {
        this.code = code
    }

}