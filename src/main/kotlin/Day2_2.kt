package dev.icefish

fun main() {
    val text = {}::class.java.classLoader
        .getResource("day2_input.txt")
        ?.readText()
        ?: error("File not found")
    println(text)
    val parts = text.split(',')
    var total: ULong = 0u
    val divisors = listOf(2, 3, 5, 7)
    for (part in parts) {
        val numbers = part.split('-')
        val number1 = numbers[0].toULong()
        val number2 = numbers[1].toULong()
        for (i in number1..number2) {
            val s = i.toString()
            for (d in divisors) {
                if (s.length % d != 0) continue

                val partSize = s.length / d
                val part = s.take(partSize)
                val allMatch = (0 until d).all { idx ->
                    s.substring(idx * partSize, (idx + 1) * partSize) == part
                }

                if (allMatch) {
                    total += i
                    println("Number: $i Parts: $d Part: $part")
                    break
                }
            }
        }
    }
    println(total)
}