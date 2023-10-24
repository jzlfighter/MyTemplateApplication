package jzl.com.crackcodeinterview.B

/**
 * 2.2　返回倒数第个节点。实现一种算法，找出单向链表中倒数第个节点。（提示：#8，#25，#41，#67，#126）
 *
 * @author jiangzailong 2022/9/7
 */
class B2 {

    private var index = 0

    fun findLastNode(lastIndex: Int, node: ListNode): ListNode {
        node.next?.let {
            val resultNode = findLastNode(lastIndex, it)
            return if (index == lastIndex) {
                resultNode
            } else {
                index++
                node
            }
        } ?: kotlin.run {
            return node
        }
    }
}
