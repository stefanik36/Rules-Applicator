package com.stefanik36.rulesapplicator

class CurrentValueStopCondition(
    private val stopValue: Long
) : StopCondition {
    private var currentValue: Long? = null

    override fun next(result: Long) {
        currentValue = result
    }

    override fun stop(): Boolean {
        return stopValue == currentValue
    }

    override fun reset() {
        currentValue = null
    }
}
