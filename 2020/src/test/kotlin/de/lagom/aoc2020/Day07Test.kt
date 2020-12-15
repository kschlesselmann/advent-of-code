package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.time.measureTimedValue

private val logger = KotlinLogging.logger {}

internal class Day07Test {

    @Nested
    inner class `Given test input` {

        val input = Input.asText("day07_test.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day07.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(4)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day07.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(32)
            }

            @Test
            fun `should yield correct result for second input`() {
                val result = Day07.partTwo(Input.asText("day07_b_test.txt"))
                assertThat(result).isEqualTo(126)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asText("day07.txt")

        @Nested
        inner class `when solving part one` {

            private val result = measureTimedValue { Day07.partOne(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 07, Part 1: ${result.value}. Computation took ${result.duration}" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = measureTimedValue { Day07.partTwo(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 07, Part 2: ${result.value}. Computation took ${result.duration}" }
            }
        }
    }

}
