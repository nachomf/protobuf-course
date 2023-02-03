package maps.main

import example.maps.Maps

fun main() {
    val message = Maps.MapExample.newBuilder()
        .putIds("key 1", newIdWrapper(1))
        .putIds("key 2", newIdWrapper(2))
        .putAllIds(
            mapOf(
                "key 3" to newIdWrapper(3),
                "key 4" to newIdWrapper(4)
            )
        )
        .build()

    println("Proto instance: $message")
}

private fun newIdWrapper(id: Int) = Maps.IdWrapper.newBuilder()
    .setId(id)
    .build()