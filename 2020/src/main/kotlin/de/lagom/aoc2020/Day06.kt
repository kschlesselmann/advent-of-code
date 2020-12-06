package de.lagom.aoc2020

object Day06 {

    fun partOne(input: String): Int = input.split("\n\n".toRegex())
        .map { it.replace("\n".toRegex(), "") }
        .map { it.asSequence().distinct().count() }
        .sum()

    fun partTwo(input: String): Int = input.split("\n\n".toRegex())
        .map { it.split("\n".toRegex()) }
        .map { it.countAll() }
        .sum()

    private fun List<String>.countAll(): Int = this
        .flatMap { it.asSequence() }
        .groupBy { it }
        .count { it.value.size == this.size }
}
