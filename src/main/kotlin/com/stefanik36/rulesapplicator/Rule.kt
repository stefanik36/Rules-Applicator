package com.stefanik36.rulesapplicator

data class Rule(
    val condition: Condition,
    val modifier: Modifier
)
