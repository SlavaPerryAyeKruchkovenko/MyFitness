package dev.kruchkovenko.core.utils

import kotlinx.coroutines.CoroutineExceptionHandler

object ExceptionHandler {
    fun coroutineExceptionHandler() =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }
}
