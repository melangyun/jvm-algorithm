package leetcode.stack

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeInorderTraversal {
    private val answer = mutableListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        inorder(root)
        return answer
    }

    private fun inorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        inorder(node.left)
        answer.add(node.`val`)
        inorder(node.right)
    }
}