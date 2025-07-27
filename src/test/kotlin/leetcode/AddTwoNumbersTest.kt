package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
    @Test
    fun addTwoNumbers1Test() {
        val addTwoNumbers = AddTwoNumbers()
        val l1 = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }
        val l2 = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
            }
        }

        val result: ListNode? = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        // 2, 4, 3
        // 5, 6, 4
        // 7, 0, 8
        var result1 = result
        while (result1 != null) {
            println(result1.`val`)
            result1 = result1.next
        }

        assertThat(addTwoNumbers.addTwoNumbers(l1, l2)).isEqualTo(result)
    }

    @Test
    fun addTwoNumbers2Test() {
        val addTwoNumbers = AddTwoNumbers()
        val l1 = ListNode(0)
        val l2 = ListNode(0)

        val result: ListNode? = ListNode(0)

        assertThat(addTwoNumbers.addTwoNumbers(l1, l2)).isEqualTo(result)
    }

    @Test
    fun addTwoNumbers3Test() {
        // [9,9,9,9,9,9,9]
        // [9,9,9,9]
        val addTwoNumbers = AddTwoNumbers()
        val l1 = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(9).apply {
                            next = ListNode(9).apply {
                                next = ListNode(9)
                            }
                        }
                    }
                }
            }
        }

        val l2 = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9)
                }
            }
        }

        // [8,9,9,9,0,0,0,1]
        val result: ListNode? = ListNode(8).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(0).apply {
                            next = ListNode(0).apply {
                                next = ListNode(0).apply {
                                    next = ListNode(1)
                                }
                            }
                        }
                    }
                }
            }
        }

        var result1 = result
        while (result1 != null) {
            println(result1.`val`)
            result1 = result1.next
        }

        assertThat(addTwoNumbers.addTwoNumbers(l1, l2)).isEqualTo(result)
    }
}