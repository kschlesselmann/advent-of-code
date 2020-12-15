package de.lagom.aoc2020

import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.time.measureTime
import kotlin.time.measureTimedValue

private val logger = KotlinLogging.logger {}

internal class Day15Test {

    @Nested
    inner class `Given test input` {


        @Nested
        inner class `when solving part one` {

            @ParameterizedTest
            @CsvSource(
                value = [
                    "0,3,6;436",
                    "1,3,2;1",
                    "2,1,3;10",
                    "1,2,3;27",
                    "2,3,1;78",
                    "3,2,1;438",
                    "3,1,2;1836",
                ],
                delimiter = ';'
            )
            fun `should yield correct result`(input: String, expexted: String) {
                val result = Day15.partOne(input)

                assertThat(result).isEqualTo(expexted.toLong())
            }
        }

        @Nested
        inner class `when solving part two` {

            @ParameterizedTest
            @CsvSource(
                value = [
                    "0,3,6;175594",
                    "1,3,2;2578",
                    "2,1,3;3544142",
                    "1,2,3;261214",
                    "2,3,1;6895259",
                    "3,2,1;18",
                    "3,1,2;362",
                ],
                delimiter = ';'
            )
            fun `should yield correct result`(input: String, expexted: String) {
                val result = Day15.partTwo(input)

                assertThat(result).isEqualTo(expexted.toLong())
            }
        }
    }

    @Nested
    inner class `Given actual input` {

        val input = Input.asText("day15.txt")

        @Nested
        inner class `when solving part one` {

            private val result = measureTimedValue { Day15.partOne(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 15, Part 1: ${result.value}. Computation took ${result.duration}" }
            }
        }

        @Nested
        inner class `when solving part two` {

            private val result = measureTimedValue { Day15.partTwo(input) }

            @Test
            fun `should log computed result`() {
                logger.info { "Result of Day 15, Part 2: ${result.value}. Computation took ${result.duration}" }
            }

        }
    }

}
