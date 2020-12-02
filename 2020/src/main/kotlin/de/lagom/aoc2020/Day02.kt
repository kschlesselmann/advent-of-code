package de.lagom.aoc2020

object Day02 {

    private val passwordPolicyRegex = "(\\d+)-(\\d+) (\\w): (.*)".toRegex()

    fun partOne(input: List<String>): Int = input
        .mapNotNull { passwordPolicyRegex.find(it)?.destructured }
        .count { (min, max, letter, password) ->
            password.isValidForSledRentalPlace(
                min = min.toInt(),
                max = max.toInt(),
                letter = letter.first()
            )
        }

    fun partTwo(input: List<String>): Int = input
        .mapNotNull { passwordPolicyRegex.find(it)?.destructured }
        .count { (positionOne, positionTwo, letter, password) ->
            password.isValidForToboggan(
                positions = setOf(positionOne.toInt(), positionTwo.toInt())
                    .map { it - 1 },
                letter = letter.first(),
            )
        }


    private fun String.isValidForSledRentalPlace(min: Int, max: Int, letter: Char): Boolean =
        this.count { it == letter } in min..max

    private fun String.isValidForToboggan(positions: List<Int>, letter: Char): Boolean =
        this.filterIndexed { index, c -> index in positions && c == letter }
            .count() == 1

}
