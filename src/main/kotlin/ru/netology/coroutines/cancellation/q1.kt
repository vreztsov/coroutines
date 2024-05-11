package ru.netology.coroutines.cancellation

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() = runBlocking {
    var a: Job? = null
    var b: Job? = null
    val job = CoroutineScope(EmptyCoroutineContext).launch {
        println(isActive)
        println(this)
        a = launch {
            println(this)
            delay(500)
            println(this)
            println("ok") // <--
        }
        println(isActive)
        println(this)
        b = launch {
            println(this)
            delay(500)
            println(this)
            println("ok")
        }
        println(this)
        println(isActive)
    }
    println(this)
    delay(100)
    println(this)
    println(job)
    println(a)
    println(b)
    job.cancel()
    println(job)
    println(a)
    println(b)
    job.join()
    println(job)
    println(a)
    println(b)
}