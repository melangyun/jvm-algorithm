package leetcode.stack

import java.util.LinkedList


class ImplementStackUsingQueues {
    val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.push(x)
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}