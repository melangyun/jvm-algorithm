package leetcode.stack

import java.util.Stack

class ImplementQueueUsingStack {

    val stack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
    }

    fun pop(): Int {
        return stack.removeFirst()
    }

    fun peek(): Int {
        return stack.first()
    }

    fun empty(): Boolean {
        return stack.empty()
    }
}