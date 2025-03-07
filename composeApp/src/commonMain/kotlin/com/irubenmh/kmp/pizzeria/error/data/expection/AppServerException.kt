package com.irubenmh.kmp.pizzeria.error.data.expection

class AppServerException(
    message: String = "Error del servidor"
) : AppConnectionException(message)