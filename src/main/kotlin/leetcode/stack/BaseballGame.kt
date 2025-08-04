package leetcode.stack

import java.util.*

class BaseballGame {
    fun calPoints(operations: Array<String>): Int {
        val stack = Stack<Int>()

        for (operation in operations) {
            if (stack.isEmpty()) {
                stack.push(operation.toInt())
                continue
            }

            when (operation) {
                "C" -> stack.pop()
                "D" -> stack.push(stack.peek() * 2)
                "+" -> {
                    val top = stack.pop()
                    val secondTop = stack.peek()
                    stack.push(top)
                    stack.push(top + secondTop)
                }
                else -> {
                    val num = operation.toIntOrNull() ?: 0
                    stack.push(num)
                }
            }
        }
        return stack.sum()
    }
}