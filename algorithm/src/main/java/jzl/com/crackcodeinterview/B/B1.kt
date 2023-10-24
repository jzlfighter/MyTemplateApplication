package jzl.com.crackcodeinterview.B

/**
 * 2.1　移除重复节点。编写代码，移除未排序链表中的重复节点。
 *
 * @author jiangzailong 2022/9/7
 */
class B1 {

    private val cache = hashSetOf<Int>()

    fun checkDuplicate(headNode: ListNode) {
        var node: ListNode? = headNode
        var preNode = headNode
        while (node != null) {
            val value = node.value
            if (!cache.contains(value)) {
                cache.add(value)
                preNode = node
                node = node.next
            } else {
                preNode.next = node.next
                node = node.next
            }
        }
    }

    class ListNode(
        var next: ListNode?,
        var value: Int
    )
}
