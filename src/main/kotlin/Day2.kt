package dev.icefish

fun main() {
    val text = {}::class.java.classLoader
        .getResource("day2_input.txt")
        ?.readText()
        ?: error("File not found")
    println(text)
    val parts = text.split(',')
    var total: ULong = 0u
    for (part in parts) {
        val numbers = part.split('-')
        val number1 = numbers[0].toULong()
        val number2 = numbers[1].toULong()
        for (i in number1..number2) {
            val temp = i.toString()
            if(temp.length%2==0) {
                val half = temp.length / 2
                val left = temp.take(half)
                val right = temp.substring(half)
                if(left==right) {
                    total+=i
                    println("Number: $i Left: $left Right: $right")
                }
            }
        }
    }
    println(total)
}