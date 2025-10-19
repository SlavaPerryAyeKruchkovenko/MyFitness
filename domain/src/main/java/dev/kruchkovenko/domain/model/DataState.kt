package dev.kruchkovenko.domain.model

sealed class DataState<T> {
    data class Error<T>(val error: Throwable) : DataState<T>()
    data class Success<T>(val result: T) : DataState<T>()
}
