package jzl.com.crackcodeinterview.B

/**
 * 2.4　分割链表。编写程序以为基准分割链表，使得所有小于的节点排在大于或等于的节点之前。如果链表中包含，只需出现在小于的元素之前（如下所示）。分割元素只需处于“右半部分”即可，其不需要被置于左右两部分之间。示例：　　输入：3>5>8>5>10>2>1[分节点为5]　　输出：3>1>2>10>5>5>8
 *
 * @author jiangzailong 2022/9/7
 */
class B4 {

    private var beforeNodeStart: ListNode? = null
    private var beforeNodeEnd: ListNode? = null
    private var afterNodeStart: ListNode? = null
    private var afterNodeEnd: ListNode? = null

    fun partition(value: Int, head: ListNode): ListNode? {
        var currentNode: ListNode? = head
        while (currentNode != null) {
            if (currentNode.value < value) {
                if (beforeNodeStart == null) {
                    beforeNodeStart = currentNode
                    beforeNodeEnd = currentNode
                } else {
                    beforeNodeEnd?.next = currentNode
                    beforeNodeEnd = currentNode
                }
            } else {
                if (afterNodeStart == null) {
                    afterNodeStart = currentNode
                    afterNodeEnd = currentNode
                } else {
                    afterNodeEnd?.next = currentNode
                    afterNodeEnd = currentNode
                }
            }
            currentNode = currentNode.next
        }
        val result = if (beforeNodeStart != null) {
            beforeNodeEnd?.next = afterNodeStart
            beforeNodeStart
        } else {
            afterNodeStart
        }
        return result
    }
}
