package io

import com.example.simple.Simple
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    fun writeTo(message: Simple,path :String){
        runCatching {
            val fos = FileOutputStream(path)
            message.writeTo(fos)
            fos.close()
        }.onFailure {
            it.printStackTrace()
        }
    }

    fun readFrom(path :String){
        runCatching {
            val fos = FileInputStream(path)
            val message = Simple.parseFrom(fos)

            println("Proto instance: $message")
        }.onFailure {
            it.printStackTrace()
        }
    }

    val message = Simple.newBuilder().apply {
        id = 1
        isSimple = false
        name = "pepe"
        addSampleList(1)
        addSampleList(2)
        addSampleList(3)
        addAllSampleList(listOf(4, 5, 6))
    }.build()

    val path = "simple.bin"

    writeTo(message, path)
    readFrom(path)
}