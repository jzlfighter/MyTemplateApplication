package jzl.com.crackcodeinterview.B

import kotlin.math.abs

/**
 * 2.7　链表相交。给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第个节点与另一个链表的第个节点是同一节点（引用完全相同），则这两个链表相交。
 *
 * @author jiangzailong 2022/9/7
 */
class B7 {

    fun findIntersection(head1: ListNode?, head2: ListNode?): ListNode? {
        val pair1 = getSizeAndTail(head1)
        val pair2 = getSizeAndTail(head2)
        if (pair1.second != pair2.second) {
            return null
        }
        var differ = abs(pair1.first - pair2.first)
        var longHead: ListNode?
        var shortHead: ListNode?
        when {
            pair1.first > pair2.first -> {
                longHead = head1
                shortHead = head2
            }
            pair1.first < pair2.first -> {
                longHead = head2
                shortHead = head1
            }
            else -> {
                longHead = head1
                shortHead = head2
            }
        }
        while (differ > 0) {
            longHead = longHead?.next
            differ--
        }
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                return longHead
            }
            longHead = longHead.next
            shortHead = shortHead.next
        }
        return null
    }

    private fun getSizeAndTail(head1: ListNode?): Pair<Int, ListNode?> {
        var size = 0
        var node = head1
        while (node != null) {
            size++
            node = node.next
        }
        return Pair(size, node)
    }
}
