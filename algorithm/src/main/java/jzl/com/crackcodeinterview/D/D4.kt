package jzl.com.crackcodeinterview.D

/**
 * 4.4　检查平衡性。实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过1。（提示：#21，#33，#49，#105，#124）
 *
 * @author jiangzailong 2022/9/26
 */
class D4 {
    fun isBalance(root: TreeNode): Boolean {
        return checkHeight(root) != Int.MIN_VALUE
    }

    private fun checkHeight(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }
        val leftHeight = checkHeight(root.left)
        if (leftHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }
        val rightHeight = checkHeight(root.right)
        if (rightHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Int.MIN_VALUE
        }
        return Math.max(leftHeight, rightHeight) + 1
    }
}
