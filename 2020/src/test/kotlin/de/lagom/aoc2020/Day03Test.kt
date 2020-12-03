package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day03Test {

    @Nested
    inner class `Given test input` {

        val input = Input.asList("day03_test.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day03.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(7)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day03.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(336)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asList("day03.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day03.partOne(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 03, Part 1: $result" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day03.partTwo(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 03, Part 2: $result" }
            }
        }
    }

}
