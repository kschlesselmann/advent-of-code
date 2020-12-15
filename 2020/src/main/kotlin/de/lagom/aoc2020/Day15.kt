package de.lagom.aoc2020

import de.lagom.aoc2020.Input.toListOfString

object Day15 {

    fun partOne(input: String): Long = input.toListOfString()
        .flatMap { it.split(",") }
        .map { it.toLong() }
        .continueAsVanEckSequence()
        .take(2020)
        .map { (_, numberSpoken) -> numberSpoken }
        .last()

    fun partTwo(input: String): Long = input.toListOfString()
        .flatMap { it.split(",") }
        .map { it.toLong() }
        .continueAsVanEckSequence()
        .take(30_000_000)
        .map { (_, numberSpoken) -> numberSpoken }
        .last()

    private fun List<Long>.continueAsVanEckSequence(): Sequence<Pair<Long, Long>> {
        val cache: MutableMap<Long, Long> = this
            .mapIndexed { round, numberSpoken -> numberSpoken to round + 1L }
            .toMap()
            .toMutableMap()

        val startingRounds = this
            .mapIndexed { round, numberSpoken -> round + 1L to numberSpoken }

        val vanEck: Sequence<Pair<Long, Long>> = generateSequence(startingRounds.last()) { (round, numberSpoken) ->
            val nextNumberSpoken: Long = cache[numberSpoken]?.let { round - it } ?: 0L
            cache[numberSpoken] = round

            round + 1 to nextNumberSpoken
        }

        return startingRounds.asSequence().take(size - 1) + vanEck
    }
}
