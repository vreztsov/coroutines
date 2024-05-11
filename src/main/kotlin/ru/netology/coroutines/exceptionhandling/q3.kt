package ru.netology.coroutines.exceptionhandling

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    CoroutineScope(EmptyCoroutineContext).launch {
        try {
            supervisorScope {
                throw Exception("something bad happened")
            }
        } catch (e: Exception) {
            println("11111111111")
            e.printStackTrace() // <--
        }
    }
    Thread.sleep(1000)
}