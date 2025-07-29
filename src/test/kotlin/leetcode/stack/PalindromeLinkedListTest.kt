package leetcode.stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PalindromeLinkedListTest{
    @Test
    fun testIsPalindrome1() {
        val head = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(2).apply {
                    next = ListNode(1)
                }
            }
        }
        val palindromeLinkedList = PalindromeLinkedList()
        assertTrue(palindromeLinkedList.isPalindrome(head))
    }

    @Test
    fun testIsPalindrome2(){
        val nonPalindromeHead = ListNode(1).apply {
            next = ListNode(2)
        }

        val palindromeLinkedList = PalindromeLinkedList()
        assertFalse(palindromeLinkedList.isPalindrome(nonPalindromeHead))
    }

    @Test
    fun testIsPalindrome3(){
        val nonPalindromeHead = ListNode(1)

        val palindromeLinkedList = PalindromeLinkedList()
        assertFalse(palindromeLinkedList.isPalindrome(nonPalindromeHead))
    }
}