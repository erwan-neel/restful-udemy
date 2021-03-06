package com.example.restfulwebservices.exception

import java.util.*

data class ExceptionResponse(
        val timestamp: Date,
        val message: String?,
        val details: String
)