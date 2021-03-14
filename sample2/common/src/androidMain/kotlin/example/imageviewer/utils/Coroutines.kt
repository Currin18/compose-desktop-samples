package example.imageviewer.utils

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope

actual fun <T> runBlocking(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
): T = kotlinx.coroutines.runBlocking(context, block)