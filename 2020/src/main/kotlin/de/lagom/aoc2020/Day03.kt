package de.lagom.aoc2020

object Day03 {

    fun partOne(input: List<String>): Int = input
        .mapIndexed { index, s -> s.environmentAt(index * 3) }
        .count { it == '#' }

    fun partTwo(input: List<String>): Int = listOf(
        1 to 1,
        3 to 1,
        5 to 1,
        7 to 1,
        1 to 2,
    )
        .map { (right, down) -> input.traverseSlope(right, down) }
        .reduce { acc, i -> acc * i }

    private fun List<String>.traverseSlope(right: Int, down: Int): Int = this
        .mapIndexedNotNull { index, s ->
            if (index % down != 0) {
                return@mapIndexedNotNull null
            }

            s.environmentAt((index / down) * right)

        }
        .count { it == '#' }

    private fun String.environmentAt(x: Int): Char = this[x % length]

}
