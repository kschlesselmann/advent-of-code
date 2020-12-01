package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day01Test {

    @Test
    fun `should solve part 1`() {
        // Given
        val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456,
        )

        // When
        val result = Day01.partOne(input)

        // Then
        assertThat(result).isEqualTo(514579)
    }

    @Test
    fun `should run part 1`() {
        // Given
        val input = Input.asList("day01.txt")
            .map { it.toInt() }

        // When
        val result = Day01.partOne(input)

        // Then
        logger.info { "Result of Day 01, Part 01: $result" }
    }

    @Test
    fun `should solve part 2`() {
        // Given
        val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456,
        )

        // When
        val result = Day01.partTwo(input)

        // Then
        assertThat(result).isEqualTo(241861950)
    }

    @Test
    fun `should run part 2`() {
        // Given
        val input = Input.asList("day01.txt")
            .map { it.toInt() }

        // When
        val result = Day01.partTwo(input)

        // Then
        logger.info { "Result of Day 01, Part 02: $result" }
    }
}
