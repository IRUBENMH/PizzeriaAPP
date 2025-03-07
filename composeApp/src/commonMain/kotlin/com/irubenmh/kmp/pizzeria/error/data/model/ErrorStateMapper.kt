package com.irubenmh.kmp.pizzeria.error.data.model

interface ErrorStateMapper {
    fun map(t: Throwable?) : ErrorState
}