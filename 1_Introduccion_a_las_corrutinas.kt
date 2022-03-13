import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }

fun main() {
    
    /*
	val thread = Thread {
		println("${Thread.currentThread()} has run.")
	}
	thread.start()
    */
    
    /*
	val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
	repeat(3) {
		Thread {
			println("${Thread.currentThread()} has started")
			for (i in states) {
				println("${Thread.currentThread()} - $i")
				Thread.sleep(50)
			}
		}.start()
	}
    */
    
    /*
	var count = 0
	for (i in 1..50) {
		Thread {
			count += 1
			println("Thread: $i count: $count")
		}.start()
	}
    */
    
    /*
	repeat(3) {
		GlobalScope.launch {
			println("Hi from ${Thread.currentThread()}")
		}
    }
    */
    
    /*
    runBlocking {
        val num1 = getValue()
        val num2 = getValue()
		println("result of num1 + num2 is ${num1 + num2}")
	}
    */
    
    /*
    runBlocking {
        val num1 = async { getValue() }
        val num2 = async { getValue() }
		println("result of num1 + num2 is ${num1.await() + num2.await()}")
	}
    */
    
	val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
	repeat(3) {
		GlobalScope.launch {
			println("${Thread.currentThread()} has started")
			for (i in states) {
				println("${Thread.currentThread()} - $i")
				delay(5000)
			}
		}.start()
	}
    
}

suspend fun getValue(): Double {
    println("entering getValue() at ${time()}")
    delay(3000)
    println("leaving getValue() at ${time()}")
    return Math.random()
}