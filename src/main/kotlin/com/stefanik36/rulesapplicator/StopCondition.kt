package com.stefanik36.rulesapplicator

interface StopCondition {
    fun next(result: Long)
    fun stop(): Boolean
    fun reset()
}
