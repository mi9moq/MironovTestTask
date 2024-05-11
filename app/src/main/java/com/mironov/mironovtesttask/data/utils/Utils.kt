package com.mironov.mironovtesttask.data.utils

import kotlin.coroutines.cancellation.CancellationException
import com.mironov.mironovtesttask.domain.entity.Result as Result

suspend fun <T> runCatchingNonCancellation(
    block: suspend () -> Result<T>
): Result<T> {
    return try {
        block()
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.Failure(e.message ?: "")
    }
}
