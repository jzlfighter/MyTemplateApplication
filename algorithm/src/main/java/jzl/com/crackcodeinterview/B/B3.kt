package jzl.com.crackcodeinterview.B

/**
 * 2.3　删除中间节点。实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。示例：　　输入：单向链表a>b>c>d>e>f中的节点c　　结果：不返回任何数据，但该链表变为a>b>d>e>f
 *
 * @author jiangzailong 2022/9/7
 */
class B3 {

    fun deleteNode(node: ListNode) {
        node.next?.let {
            node.value = it.value
            node.next = it.next
        }
    }
}
