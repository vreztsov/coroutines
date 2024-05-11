package ru.netology.coroutines.exceptionhandling

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    var a: Job? = null
    CoroutineScope(EmptyCoroutineContext).launch {
        a = CoroutineScope(EmptyCoroutineContext + SupervisorJob()).launch {
            launch {
                delay(1000)
                println("ok") // <--
            }
            launch {
                delay(500)
                println("ok")
            }
            throw Exception("something bad happened")
        }
        println(a)
    }
    Thread.sleep(1000)
    println(a)
}