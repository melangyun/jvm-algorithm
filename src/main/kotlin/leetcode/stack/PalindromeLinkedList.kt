package leetcode.stack

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        val deque = ArrayDeque<Int>()
        var pointer = head
        while (pointer?.`val` != null) {
            deque.add(pointer.`val`)
            pointer = pointer.next
        }

        while (deque.size > 1){
            if(deque.removeFirst() != deque.removeLast()){
                return false
            }
        }

        return true
    }
}