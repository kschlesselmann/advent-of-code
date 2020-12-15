package de.lagom.aoc2020

import de.lagom.aoc2020.Input.toListOfString
import kotlin.math.*

object Day12 {

    fun partOne(input: String): Long = input.toListOfString()
        .fold(Ship()) { ship, instruction -> ship + instruction }
        .distanceToOrigin()

    fun partTwo(input: String): Long = TODO()
}

data class Ship(
    val x: Long = 0,
    val y: Long = 0,
    val orientation: Int = 0
) {

    fun distanceToOrigin(): Long = x.absoluteValue + y.absoluteValue

    operator fun plus(instruction: String): Ship {
        val operation = instruction.first()
        val amount = instruction.substring(1).toInt()

        return when (operation) {
            'N' -> copy(y = y + amount)
            'S' -> copy(y = y - amount)
            'E' -> copy(x = x + amount)
            'W' -> copy(x = x - amount)
            'L' -> copy(orientation = orientation + amount)
            'R' -> copy(orientation = orientation - amount)
            'F' -> copy(
                x = x + cos(Math.toRadians(orientation.toDouble())).roundToLong() * amount,
                y = y + sin(Math.toRadians(orientation.toDouble())).roundToLong() * amount
            )
            else -> throw IllegalArgumentException("Unknown operation: $operation")
        }
    }

}
