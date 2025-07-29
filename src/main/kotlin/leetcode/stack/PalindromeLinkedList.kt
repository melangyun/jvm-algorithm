package leetcode.stack

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        val stack = Stack<Int>()
        var pointer = head
        while (pointer?.`val` != null) {
            if (stack.isEmpty() || pointer.`val` != stack.peek()) {
                stack.push(pointer.`val`)
            } else {
                stack.pop()
            }
            pointer = pointer.next
        }
        return stack.isEmpty()
    }
}