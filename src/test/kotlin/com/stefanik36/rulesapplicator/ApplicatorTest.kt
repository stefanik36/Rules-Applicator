package com.stefanik36.rulesapplicator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ApplicatorTest {
    private val threeNPlusOne: Map<Long, List<Long>> = mapOf(
        Pair(
            27,
            listOf(
                27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137,
                412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336,
                668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158,
                1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616,
                2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106,
                53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1
            )
        ),
        Pair(
            4261,
            listOf(
                4261, 12784, 6392, 3196, 1598, 799, 2398, 1199, 3598, 1799, 5398, 2699, 8098, 4049, 12148, 6074, 3037,
                9112, 4556, 2278, 1139, 3418, 1709, 5128, 2564, 1282, 641, 1924, 962, 481, 1444, 722, 361, 1084, 542,
                271, 814, 407, 1222, 611, 1834, 917, 2752, 1376, 688, 344, 172, 86, 43, 130, 65, 196, 98, 49, 148, 74,
                37, 112, 56, 28, 14, 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1,
            )
        )
    )

    @Test
    fun `When apply three n plus one for 27, then expected is returned`() {
        //given
        val value = 27L
        val applicator = Applicator(
            CurrentValueStopCondition(1),
            Rule({ it % 2 == 0L }, { it / 2L }),
            Rule({ it % 2 == 1L }, { 3 * it + 1 }),
        )

        //when
        val results = applicator.apply(value)

        //then
        assertThat(results).isEqualTo(threeNPlusOne[value])
    }

    @Test
    fun `When apply three n plus one for 4261, then expected is returned`() {
        //given
        val value = 4261L
        val applicator = Applicator(
            CurrentValueStopCondition(1),
            Rule({ it % 2 == 0L }, { it / 2L }),
            Rule({ it % 2 == 1L }, { 3 * it + 1 }),
        )

        //when
        val results = applicator.apply(value)

        //then
        assertThat(results).isEqualTo(threeNPlusOne[value])
    }
}
