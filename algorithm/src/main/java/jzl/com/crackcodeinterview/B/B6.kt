package jzl.com.crackcodeinterview.B

/**
 * 2.6　回文链表。编写一个函数，检查链表是否为回文
 *
 * @author jiangzailong 2022/9/7
 */
class B6 {

    fun isPalindrome(headNode: ListNode?): Boolean {
        val newHead = reverseAndClone(headNode)
        return isEquals(headNode, newHead)
    }

    fun reverse(headNode: ListNode?): ListNode? {
        var node: ListNode? = headNode
        var head: ListNode? = null
        while (node != null) {
            val next = node.next
            node.next = head
            head = node
            node = next
        }
        return head
    }

    fun reverseAndClone(headNode: ListNode?): ListNode? {
        var node: ListNode? = headNode
        var head: ListNode? = null
        while (node != null) {
            val newNode = ListNode(head, node.value)
            head = newNode
            node = node.next
        }
        return head
    }

    fun isEquals(node1: ListNode?, node2: ListNode?): Boolean {
        var pointer1: ListNode? = node1
        var pointer2: ListNode? = node2
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value != pointer2.value) {
                return false
            }
            pointer1 = pointer1.next
            pointer2 = pointer2.next
        }
        return pointer1 == null && pointer2 == null
    }
}
