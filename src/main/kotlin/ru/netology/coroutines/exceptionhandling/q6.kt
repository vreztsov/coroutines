package ru.netology.coroutines.exceptionhandling

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    CoroutineScope(EmptyCoroutineContext).launch {
        println("222222")
        val a = CoroutineScope(EmptyCoroutineContext).launch {
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
        a.join()
        println(a)
        println("33333333")
    }
    println("111111111111")
    Thread.sleep(1000)
}