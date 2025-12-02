package dev.icefish

import java.io.File

fun main() {
    var pos = 50
    var zeroCount = 0
    fun newPos(pos: Int, steps: Int, direction: Boolean): Int {
        var finalPos = pos
        if (direction) {
            finalPos += steps
        } else {
            finalPos-=steps
        }
        while(finalPos !in 0..99) {
            if (finalPos>99) {
                finalPos-=100
            } else {
                finalPos+=100
            }
        }
        return finalPos
    }
    fun calcLine(line: String) {
        val dir: Char = line[0]
        val num = line.drop(1).toInt()
        pos = when (dir) {
            'R' -> {
                newPos(pos, num, true)
            }
            'L' -> {
                newPos(pos, num, false)
            }
            else -> {
                error("File formatting Broken, Lines need to start with L or R")
            }
        }
        println("Pos: $pos Direction: $dir Steps:$num")
        if (pos==0) {
            zeroCount++
        }
    }


    val stream = {}::class.java.classLoader.getResourceAsStream("day1_input.txt")
        ?: error("day1_input.txt not found")

    stream.bufferedReader().forEachLine { calcLine(it) }
    println(zeroCount)
}

