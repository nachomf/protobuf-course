package json.main

import com.google.protobuf.util.JsonFormat
import com.example.simple.Simple

fun main() {

    fun toJSON(message: Simple) = JsonFormat
        .printer()
        .includingDefaultValueFields()
        .omittingInsignificantWhitespace()
        .print(message)

    fun fromJSON(json: String): Simple{
        val builder = Simple.newBuilder()
        JsonFormat.parser().merge(json, builder)
        return builder.build()
    }

    val message = Simple.newBuilder().apply {
       // id = 1
        isSimple = false
        name = "pepe"
        addSampleList(1)
        addSampleList(2)
        addSampleList(3)
        addAllSampleList(listOf(4, 5, 6))
    }.build()

    println("Proto instance: $message")

    val json = toJSON(message)

    println("JSON: $json")

    val fromJSON = fromJSON(json)

    println("FROM JSON: $fromJSON")
}