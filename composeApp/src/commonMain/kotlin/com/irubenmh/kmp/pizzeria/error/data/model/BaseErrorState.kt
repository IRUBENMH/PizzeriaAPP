package com.irubenmh.kmp.pizzeria.error.data.model

enum class BaseErrorState : ErrorState {
    NO_ERROR, BASE_GENERIC_ERROR, UNAUTHORIZED_ERROR, SERVER_ERROR, CONNECTION_ERROR, BUSINESS_ERROR;

    override var message: String? = ""
    override val value: String get() = name
}