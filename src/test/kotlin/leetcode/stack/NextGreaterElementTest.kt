package leetcode.stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NextGreaterElementTest{
    @Test
    fun testNextGreaterElement1() {
        val nextGreaterElement = NextGreaterElement()
        val nums1 = intArrayOf(4, 1, 2)
        val nums2 = intArrayOf(1, 3, 4, 2)
        val result = nextGreaterElement.nextGreaterElement(nums1, nums2)
        assertArrayEquals(intArrayOf(-1, 3, -1), result)
    }

    @Test
    fun testNextGreaterElement2() {
        val nextGreaterElement = NextGreaterElement()
        val nums1b = intArrayOf(2, 4)
        val nums2b = intArrayOf(1, 2, 3, 4)
        val resultB = nextGreaterElement.nextGreaterElement(nums1b, nums2b)
        assertArrayEquals(intArrayOf(3, -1), resultB)
    }
}