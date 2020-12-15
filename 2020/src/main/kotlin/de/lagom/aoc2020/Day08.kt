package de.lagom.aoc2020

object Day08 {

    fun partOne(input: String): Int {
        val instructions = input.trim().split("\n".toRegex())

        var acc = 0

        var currentIdx = 0
        var nextIdx = 0

        val executedInstructions = mutableListOf<Int>()

        while (nextIdx !in executedInstructions) {
            executedInstructions.add(currentIdx)
            currentIdx = nextIdx
            val currentCommand = instructions[currentIdx].split(" ")[0]
            val currentValue = instructions[currentIdx].split(" ")[1].toInt()

            when (currentCommand) {
                "acc" -> {
                    acc += currentValue
                    nextIdx = currentIdx + 1
                }
                "nop" -> {
                    nextIdx = currentIdx + 1
                }
                "jmp" -> {
                    nextIdx = currentIdx + currentValue
                }
            }
        }

        return acc
    }

    fun partTwo(input: String): Int {
        val instructions = input.trim().split("\n".toRegex())

        var acc = 0

        var currentIdx = 0
        var nextIdx = 0

        val executedInstructions = mutableListOf<Int>()

        while (nextIdx !in executedInstructions) {
            executedInstructions.add(currentIdx)
            currentIdx = nextIdx
            val currentCommand = instructions[currentIdx].split(" ")[0]
            val currentValue = instructions[currentIdx].split(" ")[1].toInt()

            when (currentCommand) {
                "acc" -> {
                    acc += currentValue
                    nextIdx = currentIdx + 1
                }
                "nop" -> {
                    nextIdx = currentIdx + 1
                }
                "jmp" -> {
                    nextIdx = currentIdx + currentValue
                }
            }
            print("")
        }

        return acc
    }

}
