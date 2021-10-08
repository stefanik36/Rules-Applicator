package com.stefanik36.rulesapplicator

import mu.KotlinLogging
import java.lang.RuntimeException

class Applicator(
    private val stopCondition: StopCondition,
    vararg vRules: Rule
) {
    private val logger = KotlinLogging.logger {}
    private val rules: List<Rule> = vRules.asList()
    private var logs: Boolean = false

    fun turnOnLogs() {
        logs = true
    }

    fun apply(value: Long): List<Long> {
        var last = value
        val results: MutableList<Long> = mutableListOf()
        addResult(results, last)
        while (!stopCondition.stop()) {
            last = applyOne(last)
            addResult(results, last)
        }
        stopCondition.reset()
        return results
    }

    private fun addResult(results: MutableList<Long>, last: Long) {
        if (logs) {
            logger.debug { "next: $last" }
        }
        results.add(last)
    }

    private fun applyOne(value: Long): Long {
        val result = rules
            .asSequence()
            .filter { it.condition.test(value) }
            .map { it.modifier.modify(value) }
            .firstOrNull() ?: throw RuntimeException("No condition met for value: $value.")
        stopCondition.next(result)
        return result
    }
}
