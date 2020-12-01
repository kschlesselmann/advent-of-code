package de.lagom.aoc2020

object Day01 {

    fun partOne(input: List<Int>) = input.asSequence()
        .flatMap { a -> input.map { b -> a to b } }
        .first { (a, b) -> a + b == 2020 }
        .let { (a, b) -> a * b }

    fun partTwo(input: List<Int>) = input.asSequence()
        .flatMap { a -> input.map { b -> a to b } }
        .flatMap { (a, b) -> input.map { c -> Triple(a, b, c) } }
        .first { it.sum() == 2020 }
        .product()

    private fun Triple<Int, Int, Int>.sum(): Int = first + second + third

    private fun Triple<Int, Int, Int>.product(): Int = first * second * third

}
