package de.lagom.aoc2020

import reactor.core.publisher.Flux
import reactor.core.publisher.toMono

typealias Regulations = Map<String, List<Pair<Int, String>>>

object Day07 {

    fun partOne(input: String): Int {
        val regulations = input.toRegulations()

        val currentPath = setOf("shiny gold bag")

        return (regulations.expandFor(currentPath) - "shiny gold bag").size
    }

    fun partTwo(input: String): Int {
        val regulations = input.toRegulations()

        return "shiny gold bag".toMono()
            .map { 1 to it }
            .expand { regulations.requirementsFor(it.first, it.second) }
            .doOnNext { println(it) }
            .map { it.first }
            .reduce { t, u -> t + u }
            .map { it - 1 }
            .block()!!
    }

    private fun Regulations.requirementsFor(number: Int, bagType: String): Flux<Pair<Int, String>> =
        Flux.fromIterable(this[bagType] ?: emptyList())
            .map { it.first * number to it.second }

    private fun String.toRegulations(): Regulations = this
        .trim()
        .replace(" bags", " bag")
        .split("\n".toRegex())
        .map { it.substringBeforeLast(".") }
        .map { it.split(" contain ") }
        .map { it[0] to it[1].parseContent() }
        .toMap()

    private fun String.parseContent(): List<Pair<Int, String>> = when (this) {
        "no other bag" -> emptyList()
        else -> this.split(", ")
            .map { it.substringBefore(" ").toInt() to it.substringAfter(" ") }
    }

    private tailrec fun Regulations.expandFor(values: Set<String>): Set<String> {
        val newValues = this
            .filter { (_, v) -> v.map { it.second }.any { it in values } }
            .map { it.key }.toSet() + values

        return if (values == newValues) {
            values
        } else {
            expandFor(newValues)
        }
    }

}
