package com.stefanik36.rulesapplicator

class ApplicatorFactory {

    fun threeNPlusOne(): Applicator {
        return Applicator(
            CurrentValueStopCondition(1),
            Rule({ it % 2 == 0L }, { it / 2L }),
            Rule({ it % 2 == 1L }, { 3 * it + 1 }),
        )
    }

    fun nPlusOne(): Applicator {
        return Applicator(
            CurrentValueStopCondition(1),
            Rule({ it % 2 == 0L }, { it / 2L }),
            Rule({ it % 2 == 1L }, { it + 1 }),
        )
    }

    fun fourNPlusOneForDivByThree(): Applicator {
        return Applicator(
            CurrentValueStopCondition(1),
            Rule({ it % 3 == 0L }, { it / 3L }),
            Rule({ it % 3 == 1L }, { it / 3L + 1 }),
            Rule({ it % 3 == 2L }, { 4 * it + 1 }),
        )
    }
}
