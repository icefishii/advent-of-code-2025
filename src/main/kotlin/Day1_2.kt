package dev.icefish

fun main() {
    var pos = 50
    var zeroCount = 0
    fun calcLine(line: String) {
        val dir = line[0]
        val steps = line.drop(1).toInt()
        val initialPos = pos

        repeat(steps) {
            pos = if (dir == 'R') {
                (pos + 1) % 100          // move 1 step right
            } else {
                (pos + 99) % 100         // move 1 step left (same as -1 mod 100)
            }

            if (pos == 0) {
                zeroCount++
            }
        }

        println("Initial Pos: $initialPos Pos: $pos Direction: $dir Steps:$steps Zero: $zeroCount")
    }

    val stream = {}::class.java.classLoader.getResourceAsStream("day1_input.txt")
        ?: error("day1_input.txt not found")

    stream.bufferedReader().forEachLine { calcLine(it) }
    println(zeroCount)
}

