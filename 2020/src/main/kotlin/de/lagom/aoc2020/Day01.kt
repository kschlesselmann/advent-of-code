package de.lagom.aoc2020

object Day01 {

    fun partOne(input: List<Int>) = input.toAllTuples()
        .first { it.sum() == 2020 }
        .product()

    fun partTwo(input: List<Int>) = input.toAllTriples()
        .first { it.sum() == 2020 }
        .product()

    private fun List<Int>.toAllTuples(): Sequence<Pair<Int, Int>> {
        val input = this

        return sequence {
            input.forEach { x ->
                input.forEach { y ->
                    yield(Pair(x, y))
                }
            }
        }
    }

    private fun Pair<Int, Int>.sum(): Int = first + second

    private fun Pair<Int, Int>.product(): Int = first * second

    private fun List<Int>.toAllTriples(): Sequence<Triple<Int, Int, Int>> {
        val input = this

        return input.toAllTuples()
            .flatMap { (x, y) -> input.map { z -> Triple(x, y, z) } }
    }

    private fun Triple<Int, Int, Int>.sum(): Int = first + second + third

    private fun Triple<Int, Int, Int>.product(): Int = first * second * third

}
