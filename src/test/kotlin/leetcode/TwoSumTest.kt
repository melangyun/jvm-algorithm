package leetcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


class TwoSumTest {
    @Test
    fun twoSum() {
        val twoSum = TwoSum()

        assertThat(twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)).isEqualTo(intArrayOf(0, 1))
        assertThat(twoSum.twoSum(intArrayOf(3, 2, 4), 6)).isEqualTo(intArrayOf(1, 2))
        assertThat(twoSum.twoSum(intArrayOf(3, 3), 6)).isEqualTo(intArrayOf(0, 1))
    }
}