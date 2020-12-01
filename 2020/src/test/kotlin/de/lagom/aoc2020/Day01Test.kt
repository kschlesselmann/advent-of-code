package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day01Test {

    @Nested
    inner class `Given test input` {

        val input = listOf(
            1721,
            979,
            366,
            299,
            675,
            1456,
        )

        @Nested
        inner class `when solving part one` {

            private val result = Day01.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(514579)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day01.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(241861950)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asList("day01.txt")
            .map { it.toInt() }

        @Nested
        inner class `when solving part one` {

            private val result = Day01.partOne(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 01, Part 1: $result" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day01.partTwo(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 01, Part 2: $result" }
            }
        }
    }

}
