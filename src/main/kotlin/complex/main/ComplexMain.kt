package complex.main

import example.complex.Complex

fun main() {
    val message = Complex.ComplexDummy.newBuilder()
        .setOneDummy(buildDummy(1, "pepe"))
        .addAllDummies(
            listOf(
                buildDummy(2, "mario"),
                buildDummy(3, "juan"),
            )
        )

    println("Proto instance: $message")
}

private fun buildDummy(id: Int, name: String) = Complex.Dummy.newBuilder()
    .setId(id)
    .setName(name)
    .build()