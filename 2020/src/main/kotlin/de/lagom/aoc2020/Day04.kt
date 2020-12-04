package de.lagom.aoc2020

object Day04 {

    fun partOne(input: List<String>): Int = input.asSingleLinePassports()
        .map { it.trim() }
        .count { it.isValid() }

    fun partTwo(input: List<String>): Int = input.asSingleLinePassports()
        .mapNotNull { Passport.fromStringDefinitionOrNull(it) }
        .count()

    private fun List<String>.asSingleLinePassports(): List<String> {
        var passport = ""
        val passports = mutableListOf<String>()

        for (line in this) {
            if (line.isBlank()) {
                passports.add(passport.trim())
                passport = ""
            } else {
                passport += " $line"
            }
        }

        passports.add(passport.trim())

        return passports
    }

    private fun String.isValid(): Boolean {
        val presentFields = split(" ")
            .map { it.substringBefore(":") }
            .filter { it.isNotBlank() }
            .toSet()

        return presentFields.containsAll(Passport.mandatoryFields)
    }
}

data class Passport(
    val birthYear: Int,
    val issueYear: Int,
    val expirationYear: Int,
    val height: Height,
    val hairColor: String,
    val eyeColor: String,
    val passportId: String,
    val countryId: String? = null,
) {

    init {
        require(birthYear in 1920..2002) { "byr $birthYear" }
        require(issueYear in 2010..2020) { "iyr $issueYear" }
        require(expirationYear in 2020..2030) { "eyr $expirationYear" }
        require(hairColor.matches(hclRegEx)) { "hcl $hairColor" }
        require(eyeColor in validEyeColors) { "ecl $eyeColor" }
        require(passportId.matches(pidRegEx)) { "pid $passportId" }
    }

    companion object {

        val mandatoryFields = setOf(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid",
        )

        private val hclRegEx = "#[0-9a-f]{6}".toRegex()
        private val pidRegEx = "[0-9]{9}".toRegex()
        private val validEyeColors = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

        fun fromStringDefinitionOrNull(definition: String): Passport? {
            val values = definition.split(" ")
                .filter { it.isNotBlank() }
                .map { it.split(":") }
                .map { it[0] to it[1] }
                .toMap()

            return try {
                Passport(
                    birthYear = values["byr"].orEmpty().toInt(),
                    issueYear = values["iyr"].orEmpty().toInt(),
                    expirationYear = values["eyr"].orEmpty().toInt(),
                    height = Height.fromString(values["hgt"].orEmpty()),
                    hairColor = values["hcl"].orEmpty(),
                    eyeColor = values["ecl"].orEmpty(),
                    passportId = values["pid"].orEmpty(),
                    countryId = values["cid"],
                )
            } catch (e: Exception) {
                null
            }
        }
    }

}

data class Height(
    val length: Int,
    val unit: String,
) {

    init {
        when (unit) {
            "cm" -> require(length in 150..193) { "hgt $length $unit" }
            "in" -> require(length in 59..76) { "hgt $length $unit" }
            else -> throw IllegalArgumentException("Height in $unit not supported")
        }
    }

    companion object {

        fun fromString(string: String): Height = if (string.endsWith("cm")) {
            Height(string.substringBefore("cm").toInt(), "cm")
        } else {
            Height(string.substringBefore("in").toInt(), "in")
        }
    }

}
