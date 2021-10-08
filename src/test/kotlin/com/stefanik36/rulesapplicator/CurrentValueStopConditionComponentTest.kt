package com.stefanik36.rulesapplicator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CurrentValueStopConditionComponentTest {

    @Test
    fun `When stop, given stop condition at 1 and next value 5, then expected false`() {
        //given
        val stopCondition = CurrentValueStopCondition(1)
        stopCondition.next(5)

        //when
        val result = stopCondition.stop()

        //then
        assertThat(result).isFalse
    }

    @Test
    fun `When stop, given stop condition at 1 and next value 1, then expected true`() {
        //given
        val stopCondition = CurrentValueStopCondition(1)
        stopCondition.next(1)

        //when
        val result = stopCondition.stop()

        //then
        assertThat(result).isTrue
    }

    @Test
    fun `When stop, given stop condition at 1 and reset, then expected false`() {
        //given
        val stopCondition = CurrentValueStopCondition(1)
        stopCondition.next(1)
        stopCondition.reset()

        //when
        val result = stopCondition.stop()

        //then
        assertThat(result).isFalse
    }
}
