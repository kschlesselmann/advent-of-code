package de.lagom.aoc2020

object Day01 {

    fun partOne(input: List<Int>) = input.asSequence()
            .flatMap { a -> input.map { b -> a to b } }
            .first { (a, b) -> a + b == 2020 }
            .let { (a, b) -> a * b }

}
