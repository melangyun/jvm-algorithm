package leetcode.stack

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class NaryTreePreorderTraversal {
    private val answer = mutableListOf<Int>()
    fun preorder(root: Node?): List<Int> {
        order(root)
        return answer
    }

    private fun order(node: Node?) {
        if (node == null) return
        answer.add(node.`val`)
        node.children.forEach {
            order(it)
        }
    }

}