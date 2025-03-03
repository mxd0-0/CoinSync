package com.example.crypto.core.domain.util

enum class NetworkError: Error {
    REQUEST_TIME_OUT,
    TOO_MANY_REQUEST,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN
}