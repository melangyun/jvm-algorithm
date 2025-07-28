package leetcode.stack

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        val brackets: Map<Char, Char> = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )

        for (char in s) {
            if(char in brackets.keys){
                stack.add(char)
            } else{
                if(stack.isEmpty()) return false
                val last = stack.removeLast()
                if(brackets[last] != char) return false
            }
        }
        return stack.isEmpty()
    }
}