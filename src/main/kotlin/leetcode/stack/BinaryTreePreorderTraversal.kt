package leetcode.stack

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class BinaryTreePreorderTraversal {
    private val answer = mutableListOf<Int>()
    fun preorderTraversal(root: TreeNode?): List<Int> {
        inorder(root)
        return answer
    }

    private fun inorder(node:TreeNode?){
        if(node == null) return
        answer.add(node.`val`)
        inorder(node.left)
        inorder(node.right)
    }
}