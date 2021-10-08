package com.stefanik36.rulesapplicator

import mu.KotlinLogging

fun main() {
    val examples = Examples()

    examples.findAndPlotLongestBetween(100000L, 110000L)
}

class Examples {
    private val logger = KotlinLogging.logger {}

    fun findAndPlotLongestBetween(start: Long, end: Long) {
        val applicator = ApplicatorFactory().threeNPlusOne()
        var longest = Pair(0L, 0)
        (start..end).forEach {
            val values = applicator.apply(it)
            if (longest.second < values.size) {
                longest = Pair(it, values.size)
            }
            logger.debug { "for $it results: ${values.size}" }
        }
        logger.debug { "longest: $longest" }
        applicator.turnOnLogs()
        val values = applicator.apply(longest.first)
        Plotter(longest.first, values).plot()
    }
}
