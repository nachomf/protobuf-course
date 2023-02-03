package simple.main

import com.example.simple.Simple

fun main() {
    /*
    val message = SimpleOuterClass.Simple.newBuilder()
        .setId(1)
        .setIsSimple(false)
        .setName("pepe")
        .addSampleList(1)
        .addSampleList(2)
        .addSampleList(3)
        .addAllSampleList(listOf(4, 5, 6))
     */

    val message = Simple.newBuilder().apply {
        id = 1
        isSimple = false
        name = "pepe"
        addSampleList(1)
        addSampleList(2)
        addSampleList(3)
        addAllSampleList(listOf(4, 5, 6))
    }

    println("Proto instance: $message")
}

