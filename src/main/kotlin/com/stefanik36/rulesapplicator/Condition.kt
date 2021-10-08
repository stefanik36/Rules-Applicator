package com.stefanik36.rulesapplicator

fun interface Condition {
    fun test(value: Long): Boolean
}
