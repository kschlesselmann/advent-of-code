package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day02Test {

    @Nested
    inner class `Given test input` {

        val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc",
        )

        @Nested
        inner class `when solving part one` {

            private val result = Day02.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(2)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day02.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(1)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asList("day02.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day02.partOne(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 02, Part 1: $result" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day02.partTwo(input)

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 02, Part 2: $result" }
            }
        }
    }

}
