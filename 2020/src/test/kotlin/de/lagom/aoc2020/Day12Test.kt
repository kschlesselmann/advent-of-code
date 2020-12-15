package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.time.measureTimedValue

private val logger = KotlinLogging.logger {}

internal class Day12Test {

    @Nested
    inner class `Given test input` {

        val input = Input.asText("day12_test.txt")

        @Nested
        inner class `when solving part one` {

            private val result = Day12.partOne(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(25)
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = Day12.partTwo(input)

            @Test
            fun `should yield correct result`() {
                assertThat(result).isEqualTo(8)
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asText("day12.txt")

        @Nested
        inner class `when solving part one` {

            private val result = measureTimedValue { Day12.partOne(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 12, Part 1: ${result.value}. Computation took ${result.duration}" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = measureTimedValue { Day12.partTwo(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 12, Part 2: ${result.value}. Computation took ${result.duration}" }
            }
        }
    }

}
