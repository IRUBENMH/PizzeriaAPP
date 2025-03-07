package com.irubenmh.kmp.pizzeria.error.data.expection

class AppHttpConnectionException(
    message: String = "Error de conexión"
) : AppConnectionException(message)