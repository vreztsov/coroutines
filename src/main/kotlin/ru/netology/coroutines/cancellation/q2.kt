package ru.netology.coroutines.cancellation

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() = runBlocking {
    val job = CoroutineScope(EmptyCoroutineContext).launch {
        println(this)
        val child = launch {
            println(this)
            delay(500)
            println(this)
            println("ok1") // <--
        }
        launch {
            println(this)
            delay(500)
            println(this)
            println("ok2")
        }
        println("Launched")
        println(this)
        println(child)
        delay(1000)
        child.cancel()
        println("Cancelled")
        println(this)
        println(child)
    }
    delay(100)
    job.join()
}