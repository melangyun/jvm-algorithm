package leetcode

data class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val answer = ListNode()

        var pointer1 = l1
        var pointer2 = l2
        var answerPointer = answer
        var nextValue = 0

        while(pointer1 != null || pointer2 != null) {
            val value1 = pointer1?.`val` ?: 0
            val value2 = pointer2?.`val` ?: 0

            val sum = value1 + value2 + nextValue
            val answerValue = sum % 10
            nextValue = sum / 10

            answerPointer.`val` = answerValue

            pointer1 = pointer1?.next
            pointer2 = pointer2?.next

            if (pointer1 != null || pointer2 != null || nextValue > 0) {
                answerPointer.next = ListNode()
                answerPointer = answerPointer.next!!
            }
        }

        return answer
    }
}
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */