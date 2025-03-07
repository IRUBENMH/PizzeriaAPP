package com.irubenmh.kmp.pizzeria.error.data.expection

class AppHttpUnauthorizedException(
    message: String = "HTTP 401 - No autorizado"
) : AppConnectionException(message)