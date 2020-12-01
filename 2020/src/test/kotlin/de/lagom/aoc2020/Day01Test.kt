package de.lagom.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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


}
