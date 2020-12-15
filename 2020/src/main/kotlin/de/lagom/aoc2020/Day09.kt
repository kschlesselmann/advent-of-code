package de.lagom.aoc2020

object Day09 {

    fun partOne(input: String): Long = input.trim().split("\n".toRegex())
        .map { it.toLong() }
        .windowed(size = 26) { it.findSumOfLastElementInPreviousElements() }
        .first { it.second == null }
        .first

    fun partTwo(input: String): Long? {
        val inputList = input.trim().split("\n".toRegex())
            .map { it.toLong() }

        for (windowSize in 2..inputList.size) {
            return inputList.windowed(windowSize) {
                if (it.sum() == 10884537L) {
                    it.first() + it.last()
                } else {
                    null
                }
            }
                .filterNotNull()
                .first()
        }

        return null
    }

    private fun List<Long>.findSumOfLastElementInPreviousElements(): Pair<Long, Pair<Long, Long>?> {
        require(this.size > 3) { "List too short" }

        val preamble = this.dropLast(1)
        val lastElement = this.last()

        preamble.forEach { a ->
            preamble.forEach { b ->
                if (a != b && a + b == lastElement) {
                    return lastElement to (a to b)
                }
            }
        }

        return lastElement to null
    }
}
