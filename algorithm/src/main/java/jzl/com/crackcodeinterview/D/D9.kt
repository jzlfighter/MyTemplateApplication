package jzl.com.crackcodeinterview.D

import java.util.LinkedList

/**
 * 4.9　二叉搜索树序列。从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。
 *
 * @author jiangzailong 2023/10/11
 */
class D9 {

    fun generateAllBSTArrays(root: TreeNode?): MutableList<LinkedList<Int>> {
        val result = mutableListOf<LinkedList<Int>>()
        if (root == null) {
            result.add(LinkedList())
            return result
        }
        val current = LinkedList<Int>()
        current.add(root.value)
        val leftList = generateAllBSTArrays(root.left)
        val rightList = generateAllBSTArrays(root.right)
        leftList.forEach { left ->
            rightList.forEach { right ->
                val weaved = mutableListOf<LinkedList<Int>>()
                weaveList(left, right, current, weaved)
                result.addAll(weaved)
            }
        }
        return result
    }

    private fun weaveList(
        leftList: LinkedList<Int>,
        rightList: LinkedList<Int>,
        prefix: LinkedList<Int>,
        result: MutableList<LinkedList<Int>>
    ) {
        if (leftList.isEmpty() || rightList.isEmpty()) {
            result.add(LinkedList<Int>().apply {
                addAll(prefix)
                addAll(leftList)
                addAll(rightList)
            })
            return
        }
        val leftFirst = leftList.removeFirst()
        prefix.addLast(leftFirst)
        weaveList(leftList, rightList, prefix, result)
        leftList.addFirst(leftFirst)
        prefix.removeLast()
        val rightFirst = rightList.removeFirst()
        prefix.addLast(rightFirst)
        weaveList(leftList, rightList, prefix, result)
        rightList.addFirst(rightFirst)
        prefix.removeLast()
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(10)
    root.right?.left = TreeNode(8)
    root.right?.right = TreeNode(11)
    println(D9().generateAllBSTArrays(root))
}
