package de.lagom.aoc2020

import de.lagom.aoc2020.Day05.toIndex
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

private val logger = KotlinLogging.logger {}

internal class Day05Test {

    @ParameterizedTest
    @CsvSource(
        value = [
            "BFFFBBF,70",
            "FFFBBBF,14",
            "BBFFBBF,102",
            "RRR,7",
            "RLL,4",
        ]
    )
    fun `should compute correct index`(input: String, expected: String) {
        val result = input.toIndex()

        assertThat(result).isEqualTo(expected.toLong())
    }

    @Nested
    inner class `Given test input` {

        val input = Input.asList("day05_test.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day05.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(820)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day05.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(336)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asList("day05.txt")

        @Nested
        inner class `when solving part one` {

            private val result = measureTimedValue { Day05.partOne(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 05, Part 1: ${result.value}. Computation took ${result.duration}" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = measureTimedValue { Day05.partTwo(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 05, Part 2: ${result.value}. Computation took ${result.duration}" }
            }
        }
    }

}
