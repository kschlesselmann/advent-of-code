package de.lagom.aoc2020

import java.lang.IllegalArgumentException
import kotlin.math.pow

object Day05 {

    fun partOne(input: List<String>): Long = input
        .filter { it.isNotBlank() }
        .map { it.seatId() }
        .maxOrNull() ?: throw IllegalStateException("Error")

    fun partTwo(input: List<String>): Long {
        val seatIds = input
            .filter { it.isNotBlank() }
            .map { it.seatId() }
            .sorted()

        seatIds.forEachIndexed { index, l ->
            if (seatIds[index + 1] != l + 1) {
                return l + 1
            }
        }

        return -1
    }

    private fun String.seatId(): Long {
        val rowDescription = this.substring(0, 7)
        val columnDescription = this.substring(7)

        val row = rowDescription.toIndex()
        val column = columnDescription.toIndex()

        return row * 8 + column
    }

    internal fun String.toIndex(): Long =
        findIndex(0L to 2.0.pow(length).toLong(), this).first

    private tailrec fun findIndex(current: Pair<Long, Long>, remainingDescription: String): Pair<Long, Long> {
        return if (remainingDescription.isBlank()) {
            current
        } else {
            val movement = remainingDescription.first()
            val remainingMovements = remainingDescription.substring(1)

            when (movement) {
                'F', 'L' -> findIndex(current.toLowerHalf(), remainingMovements)
                'B', 'R' -> findIndex(current.toUpperHalf(), remainingMovements)
                else -> throw IllegalArgumentException("Movement $movement not supported")
            }
        }
    }

    private fun Pair<Long, Long>.toLowerHalf() = first to second - (second - first) / 2

    private fun Pair<Long, Long>.toUpperHalf() = first + (second - first) / 2 to second
}
