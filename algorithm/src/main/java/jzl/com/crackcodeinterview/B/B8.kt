package jzl.com.crackcodeinterview.B

/**
 * 2.8　环路检测。给定一个有环链表，实现一个算法返回环路的开头节点。有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 * @author jiangzailong 2022/9/7
 */
class B8 {

    fun findBeginning(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                break
            }
        }
        if (fast?.next == null) {
            return null
        }
        slow = head
        while (slow != head) {
            slow = slow?.next
            fast = fast?.next
        }
        return fast
    }
}
