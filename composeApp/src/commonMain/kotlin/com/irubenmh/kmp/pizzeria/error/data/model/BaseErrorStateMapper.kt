package com.irubenmh.kmp.pizzeria.error.data.model

import com.irubenmh.kmp.pizzeria.error.data.expection.AppBusinessException
import com.irubenmh.kmp.pizzeria.error.data.expection.AppHttpConnectionException
import com.irubenmh.kmp.pizzeria.error.data.expection.AppHttpUnauthorizedException
import com.irubenmh.kmp.pizzeria.error.data.expection.AppServerException

open class BaseErrorStateMapper() : ErrorStateMapper {
    override fun map(t: Throwable?) : ErrorState {
        val errorState: BaseErrorState
        return when(t) {
            is AppHttpUnauthorizedException -> {
                errorState = BaseErrorState.UNAUTHORIZED_ERROR
                errorState.message = t.message
                errorState
            }
            is AppServerException -> {
                errorState = BaseErrorState.SERVER_ERROR
                errorState.message = t.message
                errorState
            }
            is AppBusinessException -> {
                errorState = BaseErrorState.BUSINESS_ERROR
                errorState.message = t.message
                errorState
            }
            is AppHttpConnectionException -> {
                errorState = BaseErrorState.CONNECTION_ERROR
                errorState.message = t.message
                errorState
            }
            else -> {
                errorState = BaseErrorState.BASE_GENERIC_ERROR
                errorState.message = t?.message ?: "Error inesperado"
                errorState
            }
        }
    }
}