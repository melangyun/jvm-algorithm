package leetcode

data class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val answer = ListNode(0)
        var current = answer

        var pointer1 = l1
        var pointer2 = l2
        var carry = 0

        while(pointer1 != null || pointer2 != null || carry > 0) {
            val sum = (pointer1?.`val` ?: 0) + (pointer2?.`val` ?: 0) + carry
            carry = sum / 10
            current.next = ListNode(sum %10)
            current = current.next!!

            pointer1 = pointer1?.next
            pointer2 = pointer2?.next
        }

        return answer.next
    }
}