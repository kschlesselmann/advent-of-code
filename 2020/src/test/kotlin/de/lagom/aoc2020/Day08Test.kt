package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.time.measureTimedValue

private val logger = KotlinLogging.logger {}

internal class Day08Test {

    @Nested
    inner class `Given test input` {

        val input = Input.asText("day08_test.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day08.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(5)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day08.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(8)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asText("day08.txt")

        @Nested
        inner class `when solving part one` {

            private val result = measureTimedValue { Day08.partOne(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 08, Part 1: ${result.value}. Computation took ${result.duration}" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = measureTimedValue { Day08.partTwo(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 08, Part 2: ${result.value}. Computation took ${result.duration}" }
            }
        }
    }

}
