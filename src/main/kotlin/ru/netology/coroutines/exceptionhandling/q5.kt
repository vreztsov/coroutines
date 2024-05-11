package ru.netology.coroutines.exceptionhandling

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    CoroutineScope(EmptyCoroutineContext).launch {
        try {
            supervisorScope {
                launch {
                    delay(500)
                    throw Exception("something bad happened 1") // <--
                }
                launch {
                    throw Exception("something bad happened 2")
                }
                println("222222")
            }
            println("3333333")
        } catch (e: Exception) {
            println("1111111111")
            e.printStackTrace() // <--
        }
    }
    Thread.sleep(1000)
}