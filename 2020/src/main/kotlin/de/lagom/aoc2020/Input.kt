package de.lagom.aoc2020

import java.io.File
import java.net.URI

object Input {

    fun asText(filename: String): String = File(filename.toUri()).readText().trim()

    fun asList(filename: String): List<String> = File(filename.toUri()).readLines()

    fun String.toListOfString() = trim().split("\n".toRegex())

    fun String.toListOfLong() = toListOfString()
        .map { it.toLong() }

    private fun String.toUri(): URI = Input.javaClass.classLoader.getResource(this)?.toURI()
        ?: throw IllegalArgumentException("Cannot find input file: $this")

}
