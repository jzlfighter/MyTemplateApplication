package jzl.com.crackcodeinterview.D

import java.util.LinkedList

/**
 * 4.3　特定深度节点链表。给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为，则会创建出个链表）。（提示：#107，#123，#135）
 *
 * @author jiangzailong 2022/9/26
 */
class D3 {

    fun createLinkNode(root: TreeNode): ArrayList<LinkedList<TreeNode>?> {
        val result = ArrayList<LinkedList<TreeNode>?>()
        createLinkNodeAtDepth(root, 0, result)
        return result
    }

    private fun createLinkNodeAtDepth(
        root: TreeNode?,
        depth: Int,
        input: ArrayList<LinkedList<TreeNode>?>
    ) {
        root ?: return
        val list: LinkedList<TreeNode> = input[depth] ?: kotlin.run {
            LinkedList<TreeNode>()
        }
        input[depth] = list
        list.add(root)
        createLinkNodeAtDepth(root.left, depth + 1, input)
        createLinkNodeAtDepth(root.right, depth + 1, input)
    }
}
